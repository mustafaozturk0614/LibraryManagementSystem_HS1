package com.bilgeadam.utility;

import com.bilgeadam.entity.Author;
import com.bilgeadam.entity.Book;
import com.bilgeadam.enums.EBookType;

public class CreateData {


    public static void main(String[] args) {

        Author author1=Author.builder().firstName("KEMAL").lastName("TAHİR").build();

        Book book1= Book.builder().title("Yorgun Savasci").bookType(EBookType.HISTORY).authorId(author1.getId()).build();
        Book book2= Book.builder().title("Esir Sehrin insanlari").bookType(EBookType.HISTORY).authorId(author1.getId()).build();
        Book book3= Book.builder().title("Hür Sehrin insanlari").bookType(EBookType.HISTORY).authorId(author1.getId()).build();

        Author author2=Author.builder().firstName("ALBERT").lastName("CAMUS").build();
        Book book4= Book.builder().title("Yabanci").bookType(EBookType.NOVEL).authorId(author2.getId()).build();
        Book book5= Book.builder().title("Mutlu Ölüm").bookType(EBookType.NOVEL).authorId(author2.getId()).build();
        Book book6= Book.builder().title("Sisifos Soyleni").bookType(EBookType.NOVEL).authorId(author2.getId()).build();
    }
}
