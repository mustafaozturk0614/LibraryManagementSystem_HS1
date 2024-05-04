package com.bilgeadam.controller;

import com.bilgeadam.entity.User;
import com.bilgeadam.service.UserService;
import com.bilgeadam.ui.Utility;
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

    public User login(){
        String username= Utility.stringDegerAlma("Lütfen bir kullanıcı ismi giriniz");
        String password=Utility.stringDegerAlma("Lütfen bir şifre giriniz");
        return  userService.findByUsernameAndPassword(username,password);
    }

}
