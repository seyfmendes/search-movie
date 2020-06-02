package com.seyf.movie.service;

import com.seyf.movie.model.dto.UserInfo;
import com.seyf.movie.model.entity.User;
import com.seyf.movie.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailService implements UserDetailsService {


    private UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if (user == null)
            throw new UsernameNotFoundException("not found : " + userName);
        return new UserInfo(user);
    }

}
