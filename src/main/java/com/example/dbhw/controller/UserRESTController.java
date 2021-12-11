package com.example.dbhw.controller;

import com.example.dbhw.model.User;
import com.example.dbhw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRESTController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/joinProc")
    public ResponseEntity<String> signup(@RequestBody User user){
        userService.joinUser(user);
        return new ResponseEntity<>("회원가입 완료", HttpStatus.NO_CONTENT);
    }
}
