package com.example.demo.config;

import com.example.demo.classesPackage.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtSecurity {
    private String secretKey="anabaktebhenaayklamwayhagaZXCVBNMASDFGH123456";
   public String generateToken(User user){
       SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
       return Jwts.builder()
               .subject(String.valueOf(user.getId()))//payload part holds the user id
               .issuedAt(new Date())//start date part of payload
               .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))//when the token will expire
               .signWith(key)//signature is created
               .compact();// add all of them
   }
   public int validateToken(String token){
       try{
       SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
       Claims claims = Jwts.parser()
               .verifyWith(key)
               .build()
               .parseSignedClaims(token)
               .getPayload();

       return Integer.parseInt(claims.getSubject());
       } catch (JwtException ex) {
           return -1;
       }
   }
}
