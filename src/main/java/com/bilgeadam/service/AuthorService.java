package com.bilgeadam.service;

import com.bilgeadam.entity.Author;
import com.bilgeadam.repository.AuthorRepository;
import com.bilgeadam.utility.Response;

import java.util.Optional;

public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService() {
        this.authorRepository=new AuthorRepository();
    }

    public Author save (Author author){
        return authorRepository.save(author);
    }

    public Long findAuthorIdByFirstNameAndLastName(String firstName, String lastName) {
      Optional<Long> id= authorRepository.findAuthorIdByFirstNameAndLastName( firstName,  lastName);
      return  id.orElseThrow(()-> new RuntimeException("Yazar bulunamadı"));
    }


}
