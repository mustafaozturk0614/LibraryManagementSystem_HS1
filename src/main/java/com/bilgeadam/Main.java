package com.bilgeadam;

import com.bilgeadam.controller.UserController;
import com.bilgeadam.entity.User;
import com.bilgeadam.repository.AuthorRepository;
import com.bilgeadam.repository.UserRepository;
import com.bilgeadam.ui.LibraryUi;
import com.bilgeadam.utility.CreateData;

/*
1. User (Kullanıcı)
• Kullanıcıların kimlik bilgilerini (id, username, password) ve ilişkili kullanıcı bilgilerini
(UserInformation) temsil eder.
• Tekil ilişkiye sahip olduğu UserInformation varlığı, kullanıcının ad, soyad, telefon
numarası gibi kişisel bilgilerini içerir.
2. UserInformation (Kullanıcı Bilgileri)
• Kullanıcının kişisel bilgilerini içerir (firstName, lastName, phoneNumber).
• Çoklu ilişkiye sahip olduğu Address varlığı, kullanıcının birden fazla adres bilgisini
temsil eder.
3. Borrow (Ödünç Alma)
• Kullanıcıların kitapları ödünç aldığı işlemleri temsil eder.
• Kullanıcılar ve kitaplar arasında birçoklu ilişkiye sahiptir.
4. Book (Kitap)
• Kütüphanedeki kitapları temsil eder.
• Yazarlar ile ilişkilidir ve kategorize edilmiş kitap türleri (bookType) içerir.
• NOVEL("Roman"),
• FICTION("Kurgu"),
• NONFICTION("Gerçek"),
• SCIENCE_FICTION("Bilim Kurgu"),
• FANTASY("Fantazi"),
• MYSTERY("Gizem"),
• THRILLER("Gerilim"),
• ROMANCE("Aşk"),
• HORROR("Korku"),
• BIOGRAPHY("Biyografi"),
• HISTORY("Tarih"),
• SCIENCE("Bilim"),
• POETRY("Şiir"),
• GRAPHIC_NOVEL("Grafik Roman"),
• COMIC_BOOK("Çizgi Roman"),
• COOKBOOK("Yemek Kitabı"),
• DIARY("Günlük"),
• JOURNAL("Dergi"),
• TRAVEL("Seyahat"),
• HEALTH("Sağlık"),
• RELIGION("Din"),
• TEXTBOOK("Ders Kitabı"),
• REFERENCE("Kaynak"),
• ART("Sanat"),
• DETECTIVE("Polisiye");
5. Author (Yazar)
• Kitapların yazarlarını temsil eder.
• Bir kitabın sadece 1 tane yazarı olacağını varsayıyoruz
6. Address (Adres)
• Kullanıcıların fiziksel adres bilgilerini temsil eder
 */
public class Main {
    public static void main(String[] args) {

   //     UserRepository userRepository=new UserRepository();
    //    userRepository.save(User.builder().username("mustafa").password("123").build());
   //     AuthorRepository authorRepository=new AuthorRepository();
      //  System.out.println( authorRepository.findAuthorIdByFirstNameAndLastName("KEMAL","TAHİR"));  ;
//        System.out.println( userRepository.findbyUsername("mustafa"));
//        System.out.println( userRepository.findbyUsername("mustafa"));
    //    System.out.println( userRepository.findByUsernameAndPasswordHQL("mustafa","123"));

  //      UserController userController=new UserController();
        LibraryUi ui=new LibraryUi();
  //      CreateData createData=new CreateData();
     //   createData.initilazeData();
        ui.startApp();
      //  System.out.println(userController.register());


    }
}