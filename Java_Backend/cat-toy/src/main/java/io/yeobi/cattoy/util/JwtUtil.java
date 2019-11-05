package io.yeobi.cattoy.util;

import io.jsonwebtoken.Claims;
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
    private final Key key;

    public JwtUtil(String secret) {
        key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String createToken(long userId, String name) {
        String token = Jwts.builder()
                .claim("userId", userId)
                .claim("name", name)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    public Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }
}
