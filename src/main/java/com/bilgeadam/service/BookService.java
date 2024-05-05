package com.bilgeadam.service;

import com.bilgeadam.entity.Author;
import com.bilgeadam.entity.Book;
import com.bilgeadam.enums.EBookType;
import com.bilgeadam.repository.AuthorRepository;
import com.bilgeadam.repository.BookRepository;
import com.bilgeadam.ui.Utility;

public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookService() {

        this.bookRepository=new BookRepository();
        this.authorService=new AuthorService();
    }

    public Book save (Book book){
        return bookRepository.save(book);

    }

    public EBookType getBookType() {
     EBookType [] bookTypes =EBookType.values();
     for (EBookType type:bookTypes){
         //1-NOVEL
         //2-Fiction
         System.out.println((type.ordinal()+1)+ "-"+type);
     }
     int select= Utility.intDegerAlma("Lütfen kitap turunu seciniz");
        return  bookTypes[select-1];
    }

    public Long getAuthorId(String firstName, String lastName) {
        return  authorService.findAuthorIdByFirstNameAndLastName(firstName,lastName);
    }
}
