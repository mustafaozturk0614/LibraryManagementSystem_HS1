package com.bilgeadam.controller;

import com.bilgeadam.entity.Book;
import com.bilgeadam.enums.EBookType;
import com.bilgeadam.service.BookService;
import com.bilgeadam.ui.Utility;
import com.bilgeadam.utility.Response;

public class BookController {

    private final BookService bookService;

    public BookController() {
        this.bookService=new BookService();
    }


    public Response<Book> createBook(){
        Response<Book> response=new Response<>();
        try {
            String title= Utility.stringDegerAlma("lütfen bir kitap ismi giriniz");
            EBookType bookType= bookService.getBookType();
            int pageCount= Utility.intDegerAlma("Lütfen sayfa sayısı giriniz");
            String firstName= Utility.stringDegerAlma("Lütfen yazar adı giriniz");
            String lastName= Utility.stringDegerAlma("Lütfen yazar soyadı giriniz");
            Long authorId=bookService.getAuthorId(firstName,lastName);
            Book book=bookService.save(Book.builder().title(title).pageCount(pageCount).bookType(bookType).authorId(authorId).build());
            response.setData(book);
            response.setStatusCode(200);
            response.setMessage("Kitap başarı ile olusturuldu");
        }catch (Exception e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage()+": Kitap oluşturulamadı!!!!");
        }
        return  response;
    }
}
