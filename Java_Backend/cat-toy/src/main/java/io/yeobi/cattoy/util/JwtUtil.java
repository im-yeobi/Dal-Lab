package io.yeobi.cattoy.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

/**
 * @author yeobi
 * @created 2019-11-05
 */
public class JwtUtil {
    // 256 / 8 = 32자리 수보다 커야한다.
    private final String secret;

    public JwtUtil(String secret) {
        this.secret = secret;
    }

    public String createToken(long userId, String name) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        String token = Jwts.builder()
                .claim("userId", userId)
                .claim("name", name)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return token;
    }
}
