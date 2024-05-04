package com.bilgeadam.utility;

import java.util.List;
import java.util.Optional;

public interface ICrud <T,ID>{

    T save(T entity); // kayıttan sonra enttity'i geri döndürürsek daha iyi olur.
    Iterable<T> saveAll(Iterable<T> entities); // List,set gibi bir iterable dizi tutar.
    Optional<T> findById(ID id); // veriler null gelmemeli bunla uğraşamayız
    boolean existsById(ID id); // böyle bir kayıt var mı?
    List<T> findAll(); // tum kayıtları getirir

    /**
     * Bir post'un yorum listesini bulmak istiyorum.
     * select * from tblpost where id = 1
     */
    List<T> findByColumnAndValue(String columnName, Object value);
    // value ,string id olabilir, boolen bir değer olabilir, int bir deger olabilir. O yüzden object

    // kayıtlar genelde ID ile silinir
    void deleteById(ID id);

    // özel bir method yazalım , sorgu
    List<T> findAllByEntity(T entity);
}
