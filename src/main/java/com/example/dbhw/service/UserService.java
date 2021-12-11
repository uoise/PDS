package com.example.dbhw.service;

import com.example.dbhw.model.User;
import com.example.dbhw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void joinUser(User user){
        userRepository.save(user);
    }
}
