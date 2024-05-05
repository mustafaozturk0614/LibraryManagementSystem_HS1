package com.bilgeadam.ui;

import com.bilgeadam.controller.UserController;
import com.bilgeadam.entity.User;
import com.bilgeadam.utility.Response;

public class LibraryUi {

    UserController userController;
    User currentUser;

    public LibraryUi() {
        this.userController=new UserController();
    }

    public  void mainMenu(){
        System.out.println("====KÜTÜPHANE YÖNETİM SİSTEMİ");
        System.out.println("1-Kayıt ol");
        System.out.println("2-Giriş yap");
        System.out.println("0-Çıkış yap");
    }

    public void  userMenu(){
        int control=0;
        do {
            System.out.println(currentUser.getUsername()+"==> HOŞ GELDİNİZ");
            System.out.println("1-Profil bilgilerini guncelle");
            System.out.println("2-Kitap listele");
            System.out.println("3-Kitap kirala");
            System.out.println("4-Yazarları listele");
            System.out.println("5-Kitap ekle");
            System.out.println("6-Yazar ekle");
            System.out.println("7-Üst menuye don");
            System.out.println("8-Kiralamaları goster");
            System.out.println("0-Çıkış");

           control= Utility.intDegerAlma("Lütfen secim yapınız");
           switch (control){
               case 1:
                   break;
               case 2:
                   break;
               case 7:
                   System.out.println("Üst menuye donuluyor....");
                   startApp();
                   break;
               case 0:
                   System.out.println("Program sonlanıyor...");
                   break;
               default:
                   break;
           }
        }while (control!=0);
    }

    public  void  startApp(){

        int control;
        do {
            mainMenu();
            control=Utility.intDegerAlma("lütfen bir secim yapınız");
            switch (control){
                case 1:
                    userController.register();
                    break;
                case 2:
                    control=checkLogin();
                    break;
                case 0:
                    System.out.println("Program sonlanıyor....");
                    break;
                default:
                    break;
            }

        }while (control!=0);

    }

    public int  checkLogin(){
      Response<User> userResponse =userController.login();
        if (userResponse.getStatusCode()==200){
            System.out.println(userResponse.getMessage());
            currentUser=userResponse.getData();
            userMenu();
            return 0;
        }else {
            System.out.println(userResponse.getMessage());
            return 2;
        }
    }

}
