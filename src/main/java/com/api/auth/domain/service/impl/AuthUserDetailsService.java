package com.api.auth.domain.service.impl;

import com.api.auth.config.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;

@Service
@CrossOrigin
public class AuthUserDetailsService implements UserDetailsService {
  @Autowired
  private JWTUtil jwtUtil;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    return new User(s,"SBS2021",new ArrayList<>());
  }

  public boolean checkToken(String jwt, UserDetails userDetails){
    return jwtUtil.validateToken(jwt, userDetails);
  }
}
