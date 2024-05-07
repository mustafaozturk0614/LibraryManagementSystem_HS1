package com.bilgeadam.repository;

import com.bilgeadam.entity.Author;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.Optional;

public class AuthorRepository extends Repository<Author,Long >{

    public AuthorRepository() {
        super(new Author());
    }


    public Optional<Long> findAuthorIdByFirstNameAndLastNameNamedQuery(String firstName, String lastName){
        TypedQuery<Long> typedQuery=getEm().createNamedQuery("findAuthorIdByFirstNameAndLastName",Long.class);
        typedQuery.setParameter("firstName",firstName);
        typedQuery.setParameter("lastName",lastName);
        Long id=null;
        try {
        id=  typedQuery.getSingleResult();
        }catch (Exception e){
            System.out.println("Yazar bulunamadı");
        }
        return Optional.ofNullable(id);
    }

    public Optional<Long> findAuthorIdByFirstNameAndLastName(String firstName, String lastName){
        CriteriaBuilder criteriaBuilder=getEm().getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery=criteriaBuilder.createQuery(Long.class);
        Root<Author> root=criteriaQuery.from(Author.class);
        Predicate predicate1=criteriaBuilder.and(criteriaBuilder.equal( root.get("firstName"),firstName),criteriaBuilder.equal(root.get("lastName"),lastName)) ;
        criteriaQuery.select(root.get("id")).where(predicate1);
        Long id=null;
        try {
            id=getEm().createQuery(criteriaQuery).getSingleResult();
        }catch (Exception e){
            System.out.println("Yazar bulunamadı");
        }
        return Optional.ofNullable(id);
    }
}
