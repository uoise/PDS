package com.example.dbhw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    @GetMapping("/login")
    public String loginForm(){
        return "user/loginform";
    }

    @GetMapping("/user/join")
    public String joinForm(){
        return "user/joinform";
    }

}
