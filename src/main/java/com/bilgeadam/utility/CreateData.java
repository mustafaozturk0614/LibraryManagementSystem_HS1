package com.bilgeadam.utility;

import com.bilgeadam.entity.Author;
import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.User;
import com.bilgeadam.enums.EBookType;
import com.bilgeadam.repository.AuthorRepository;
import com.bilgeadam.repository.BookRepository;
import com.bilgeadam.repository.UserRepository;

import java.util.List;

public class CreateData {


    public static void main(String[] args) {
        AuthorRepository authorRepository=new AuthorRepository();
        BookRepository bookRepository=new BookRepository();
        UserRepository userRepository=new UserRepository();
        Author author1=Author.builder().firstName("KEMAL").lastName("TAHİR").build();

        Book book1= Book.builder().title("Yorgun Savasci").bookType(EBookType.HISTORY).authorId(author1.getId()).build();
        Book book2= Book.builder().title("Esir Sehrin insanlari").bookType(EBookType.HISTORY).authorId(author1.getId()).build();
        Book book3= Book.builder().title("Hür Sehrin insanlari").bookType(EBookType.HISTORY).authorId(author1.getId()).build();

        Author author2=Author.builder().firstName("ALBERT").lastName("CAMUS").build();
        Book book4= Book.builder().title("Yabanci").bookType(EBookType.NOVEL).authorId(author2.getId()).build();
        Book book5= Book.builder().title("Mutlu Ölüm").bookType(EBookType.NOVEL).authorId(author2.getId()).build();
        Book book6= Book.builder().title("Sisifos Soyleni").bookType(EBookType.NOVEL).authorId(author2.getId()).build();


        authorRepository.save(author1);
        authorRepository.save(author2);
        Author author3=Author.builder().firstName("SAIT FAIK").lastName("ABASIYANIK").build();
        Book book7= Book.builder().title("Son Kuslar").bookType(EBookType.NOVEL).authorId(author3.getId()).build();

        Author author4=Author.builder().firstName("Nikoloy".toUpperCase()).lastName("Gogol".toUpperCase()).build();
        Book book8= Book.builder().title("Olu Canlar").bookType(EBookType.NOVEL).authorId(author4.getId()).build();
        Book book9= Book.builder().title("Palto").bookType(EBookType.NOVEL).authorId(author4.getId()).build();


        Author author5=Author.builder().firstName("").lastName("Gogol").build();
        Book book10= Book.builder().title("SEVME SANATI").bookType(EBookType.NONFICTION).authorId(author5.getId()).build();
        Book book11= Book.builder().title("OZGURLUKTEN KACIS").bookType(EBookType.NONFICTION).authorId(author5.getId()).build();

        List<Book> books=List.of(book1,book2,book3,book4,book5,book6,book7,book8,book9,book10,book11);
        List<Author> authors=List.of(author1,author2,author3,author4,author5);

        User user1=User.builder().username("mustafa").password("123").build();
        User user2=User.builder().username("serkan").password("123").build();
        userRepository.save(user1);
        userRepository.save(user2);
        authorRepository.saveAll(authors);
        bookRepository.saveAll(books);



    }

    public   void  initilazeData(){
        AuthorRepository authorRepository=new AuthorRepository();
        BookRepository bookRepository=new BookRepository();
        UserRepository userRepository=new UserRepository();
        Author author1=Author.builder().firstName("KEMAL").lastName("TAHİR").build();



        Author author2=Author.builder().firstName("ALBERT").lastName("CAMUS").build();




        Author author3=Author.builder().firstName("SAIT FAIK").lastName("ABASIYANIK").build();


        Author author4=Author.builder().firstName("Nikoloy".toUpperCase()).lastName("Gogol".toUpperCase()).build();



        Author author5=Author.builder().firstName("").lastName("Gogol").build();



        List<Author> authors=List.of(author1,author2,author3,author4,author5);

        User user1=User.builder().username("mustafa").password("123").build();
        User user2=User.builder().username("serkan").password("123").build();
        userRepository.save(user1);
        userRepository.save(user2);
        authors.forEach(x->authorRepository.save(x));
        // authorRepository.saveAll(authors);
        Book book4= Book.builder().title("Yabanci").bookType(EBookType.NOVEL).authorId(author2.getId()).build();
        Book book5= Book.builder().title("Mutlu Ölüm").bookType(EBookType.NOVEL).authorId(author2.getId()).build();
        Book book6= Book.builder().title("Sisifos Soyleni").bookType(EBookType.NOVEL).authorId(author2.getId()).build();
        Book book1= Book.builder().title("Yorgun Savasci").bookType(EBookType.HISTORY).authorId(author1.getId()).build();
        Book book2= Book.builder().title("Esir Sehrin insanlari").bookType(EBookType.HISTORY).authorId(author1.getId()).build();
        Book book3= Book.builder().title("Hür Sehrin insanlari").bookType(EBookType.HISTORY).authorId(author1.getId()).build();
        Book book7= Book.builder().title("Son Kuslar").bookType(EBookType.NOVEL).authorId(author3.getId()).build();
        Book book8= Book.builder().title("Olu Canlar").bookType(EBookType.NOVEL).authorId(author4.getId()).build();
        Book book9= Book.builder().title("Palto").bookType(EBookType.NOVEL).authorId(author4.getId()).build();
        Book book10= Book.builder().title("SEVME SANATI").bookType(EBookType.NONFICTION).authorId(author5.getId()).build();
        Book book11= Book.builder().title("OZGURLUKTEN KACIS").bookType(EBookType.NONFICTION).authorId(author5.getId()).build();
        List<Book> books=List.of(book1,book2,book3,book4,book5,book6,book7,book8,book9,book10,book11);

      // bookRepository.saveAll(books);
        books.forEach(x->bookRepository.save(x));

    }
}
