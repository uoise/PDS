package com.example.dbhw.config.auth;

import com.example.dbhw.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetail implements UserDetails {

    @Getter
    private User user;

    public PrincipalDetail(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add((GrantedAuthority) () -> "ROLE_"+user.getRole());
        return collectors;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // not set yet
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // not set yet
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // not set yet
    }

    @Override
    public boolean isEnabled() {
        return true; // not set yet
    }

}
