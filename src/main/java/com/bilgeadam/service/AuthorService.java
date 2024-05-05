package com.bilgeadam.service;

import com.bilgeadam.entity.Author;
import com.bilgeadam.repository.AuthorRepository;
import com.bilgeadam.utility.Response;

public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService() {
        this.authorRepository=new AuthorRepository();
    }

    public Author save (Author author){
        return authorRepository.save(author);
    }
}
