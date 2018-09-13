package com.jzc.spring.boot.api.service.impl;

import com.jzc.spring.boot.api.data.UserInfoData;
import com.jzc.spring.boot.api.model.User;
import com.jzc.spring.boot.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collections;

@Component("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserInfoData userInfoData;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("username " + username + " is null");
        }
        User user = userInfoData.findUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("user" + username + "was not found");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.EMPTY_SET
        );
    }

}
