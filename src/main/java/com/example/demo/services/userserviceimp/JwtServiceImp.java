package com.example.demo.services.userserviceimp;

import com.example.demo.services.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class JwtServiceImp implements JwtService {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(int id) {
        return Jwts.builder()
                .setSubject(id+"")
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validToken(String authToken) {
        return Boolean.parseBoolean(Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken).getBody().getSubject());
    }

}
