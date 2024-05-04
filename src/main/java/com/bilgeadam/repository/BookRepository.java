package com.bilgeadam.repository;

import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.UserInformation;

public class BookRepository extends Repository<Book,Long >{

    public BookRepository() {
        super(new Book());
    }
}
