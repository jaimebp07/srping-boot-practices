package com.mycompany.roles_and_auth.infrastructure.security.jwt;

import java.security.Key;
import java.util.Date;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtUtil {

    @Value("${jwt.secret.key}")
    private  String secretKey;

    @Value("${jwt.time.expiration}")
    private long expirationTime;

    public String generateToken(String username, Set<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSignatureKey(), SignatureAlgorithm.ES256)
                .compact();
    }

    public String getUsernameFromToken(String token){
        return getClaim(token, Claims :: getSubject);
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction){
        Claims claims = extractClaims(token);
        return claimsTFunction.apply(claims);
    }

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignatureKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(String token) {
        try {
            extractClaims(token);
            return true;
        } catch (JwtException e) {
            log.error("Invalid token, error: ".concat(e.getMessage()));
            return false;
        }
    }

    public Key getSignatureKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
