package com.bilgeadam.controller;

import com.bilgeadam.entity.User;
import com.bilgeadam.service.UserService;
import com.bilgeadam.ui.Utility;
import com.bilgeadam.utility.Response;
import lombok.RequiredArgsConstructor;


public class UserController {

    private final UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public User register(){
        String username= Utility.stringDegerAlma("Lütfen bir kullanıcı ismi giriniz");
        String password=Utility.stringDegerAlma("Lütfen bir şifre giriniz");
        User user=User.builder().username(username).password(password).build();
        return   userService.save(user);

    }

    public Response<User> login(){
        String username= Utility.stringDegerAlma("Lütfen bir kullanıcı ismi giriniz");
        String password=Utility.stringDegerAlma("Lütfen bir şifre giriniz");
        Response<User> response=new Response<>();
        try {
           User user= userService.findByUsernameAndPassword(username,password);
            response.setData(user);
            response.setStatusCode(200);
            response.setMessage("Giriş Başarılı");
        }catch (Exception e){
            response.setStatusCode(400);
            response.setMessage("Kullanıc adı veya Şifre hatalı");
        }
        return response ;
    }

}
