package com.seyf.movie.model.dto;


import com.seyf.movie.enums.Status;
import com.seyf.movie.model.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserInfo implements UserDetails {

    private List<GrantedAuthority> authorities = new ArrayList<>();
    private String password;
    private String username;
    private boolean enable;

    public UserInfo(User user) {
        this.username = user.getUserName();
        this.password = user.getPassword();
        this.enable = user.getStatus() == Status.ACTIVE;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
}
