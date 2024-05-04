package com.bilgeadam.repository;

import com.bilgeadam.entity.Author;
import com.bilgeadam.entity.Barrow;

public class AuthorRepository extends Repository<Author,Long >{

    public AuthorRepository() {
        super(new Author());
    }
}
