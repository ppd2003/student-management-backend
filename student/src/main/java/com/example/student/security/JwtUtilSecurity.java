package com.example.student.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtilSecurity {

    private static final String SECRETE = "mysecretkeymysecretkeymysecretkey123";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; //1HOUR

    private static final Key key= Keys.hmacShaKeyFor(SECRETE.getBytes());

    public static String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public static String extraUsername(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static boolean validateToken(String token){
        try {
            extraUsername(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
