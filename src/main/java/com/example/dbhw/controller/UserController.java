package com.example.dbhw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    @GetMapping("/auth/loginform")
    public String loginForm(){
        return "user/loginform";
    }

    @GetMapping("/auth/joinform")
    public String joinForm(){
        return "user/joinform";
    }

}
