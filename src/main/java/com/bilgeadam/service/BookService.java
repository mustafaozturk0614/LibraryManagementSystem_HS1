package com.bilgeadam.service;

import com.bilgeadam.entity.Author;
import com.bilgeadam.entity.Book;
import com.bilgeadam.repository.AuthorRepository;
import com.bilgeadam.repository.BookRepository;

public class BookService {

    private final BookRepository bookRepository;

    public BookService() {
        this.bookRepository=new BookRepository();
    }

    public Book save (Book book){
        return bookRepository.save(book);
    }
}
