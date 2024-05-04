package com.bilgeadam.repository;

import com.bilgeadam.utility.ICrud;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Getter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class Repository<T,ID> implements ICrud<T,ID> {

    private final EntityManagerFactory emf;
    private EntityManager em;
    private T t;
    //  T result;

    public Repository(T entity) {
        emf = Persistence.createEntityManagerFactory("lbms");
        em = emf.createEntityManager();
        this.t = entity;
    }

    /*
    Burada bağlantı açma ve kapama methodlarını belirtmemiz gerkeiyor. Clean Code açısında da temiz olur.
     */

    // --------------------****************------------------------------------------------------
    private void openSession(){
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    private void closeSession(){
        em.getTransaction().commit();
        em.close();
    }

    //Ayrıca bir hata durumunda rollback yapabilmemiz için bu methodu'da eklememiz doğru olur.
    private void rollback(){
        em.getTransaction().rollback();
        em.close();
    }
    // --------------------****************------------------------------------------------------

    private void openSS(){
        if(!em.isOpen())
            em = emf.createEntityManager();
    }
    @Override
    public T save(T entity) {
        openSession();
        em.persist(entity);
        closeSession();
        return entity;
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> entities) {
        openSS();
        try{
            openSession();
            entities.forEach(em::persist);
        }catch (Exception e){
            rollback();
        }
        return entities;
    }

    /**
     * select * from tbl*** where id= *
     * @param id
     * @return
     * Burada transaction kısmına ihtiyacımız yok.
     */

    @Override
    public Optional<T> findById(ID id) {
        openSession();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass()); // casting işlemi yaptık
        Root<T> root =(Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root); // ->>> select * from
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"),id)); // ->>> where id=*
        T result;
        try {
            // ->> Tek bir sonuç almak için singleresult kullanılır
            result = em.createQuery(criteriaQuery).getSingleResult();
            return Optional.of(result);
        }catch (NoResultException exception){
            return Optional.empty();
        }
    }

    @Override
    public boolean existsById(ID id) {
        openSS();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"),id));
        try{
            em.createQuery(criteriaQuery).getSingleResult();
            return true;
        }catch (NoResultException exception){
            return false;
        }
    }

    @Override
    public List<T> findAll() {
        openSS();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<T> findByColumnAndValue(String columnName, Object value) {
        openSS();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery =(CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get(columnName),value));
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void deleteById(ID id) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"),id));
        T removeElement;
        try{
            removeElement = em.createQuery(criteriaQuery).getSingleResult();
        }catch (NoResultException exception){
            removeElement = null;
        }
        try {
            openSession();
            em.remove(removeElement);
            closeSession();
        }catch (Exception e){
            if(em.isOpen()){
                rollback();
            }
        }

    }

    /**
     *     Reflection ile sınıf parçalanır. Java Reflection
     *     Long userid -> if(userid != null) sorguya dahil et -> userid, value
     * @param entity
     * @return
     */

    @Override
    public List<T> findAllByEntity(T entity) {
        openSS();
        List<T> result;
        Class<?> clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        // şimdi where içeriğini null olmayan değişkenleri predicate olarak eklenmesini sağlayacağız.
        List<Predicate> predicateList = new ArrayList<>();
        for(int i = 1; i<fields.length;i++){
            fields[i].setAccessible(true); //->> private olanları public olarak görmeyi sağlıyoruz.
            try{
                String column = fields[i].getName();
                Object value = fields[i].get(entity);
                if(value != null){
                    if (value instanceof String) {
                        predicateList.add(criteriaBuilder.like(root.get(column), "%" + value + "%"));
                        // burada String olanları alıyoruz
                    }else{
                        predicateList.add(criteriaBuilder.equal(root.get(column),value));
                    }
                }

            }catch (Exception e){
                System.out.println("Hata var: "+ e);
            }
        }
        criteriaQuery.where(predicateList.toArray(new Predicate[]{}));
        result = em.createQuery(criteriaQuery).getResultList();
        return result;
    }
}
