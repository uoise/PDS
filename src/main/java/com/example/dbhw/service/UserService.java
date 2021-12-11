package com.example.dbhw.service;

import com.example.dbhw.model.RoleType;
import com.example.dbhw.model.User;
import com.example.dbhw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void joinUser(User user){
        String encPWD = encoder.encode(user.getPassword());
        user.setPassword(encPWD);
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }
}
