/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softek.jwtdemo.controller;


import com.softek.jwtdemo.dto.*;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.stream.Collectors;


/**
 *
 * @author Chris
 */
@RestController
public class UserController {
    
    @PostMapping("user")
    public User Login(@RequestParam("user") String username, @RequestParam("password") String pwd){
        String token = getJWTToken(username);
        User user = new User();
        user.setUser(username);
        user.setTkn(token);
        return user;
    }
    
    private String getJWTToken(String username){
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
       String token = Jwts.builder()
               .setId("softtekJWT")
               .setSubject(username)
               .claim("authorities",grantedAuthorities.stream()
               .map(GrantedAuthority::getAuthority)
               .collect(Collectors.toList()))
               .setIssuedAt(new Date(System.currentTimeMillis()))
               .setExpiration(new Date(System.currentTimeMillis() + 600000))
               .signWith(SignatureAlgorithm.HS512,
                       secretKey.getBytes()).compact();
               
       return "Bearer " + token;
    }
    
}
