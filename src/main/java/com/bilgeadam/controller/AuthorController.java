package com.bilgeadam.controller;

import com.bilgeadam.entity.Author;
import com.bilgeadam.service.AuthorService;
import com.bilgeadam.ui.Utility;
import com.bilgeadam.utility.Response;

public class AuthorController {

    private  final AuthorService authorService;

    public AuthorController() {
        this.authorService=new AuthorService();
    }

    public Response<Author> createAuthor(){
        String firstName= Utility.stringDegerAlma("Lütfen yazar adı giriniz");
        String lastName= Utility.stringDegerAlma("Lütfen yazar soyadı giriniz");
        Response<Author> response=new Response<>();
        try {
            Author author =authorService.save(Author.builder().firstName(firstName).lastName(lastName).build());
            response.setStatusCode(200);
            response.setMessage("Kayıt Başarılı");
            response.setData(author);
        }catch (Exception e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage()+": Kayıt Başarısız");
        }
        return response;
    }
}
