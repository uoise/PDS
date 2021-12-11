package com.example.dbhw.config.auth;

import com.example.dbhw.model.User;
import com.example.dbhw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(s).orElseThrow(()-> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다."));
        return new PrincipalDetail(principal);
    }
}
