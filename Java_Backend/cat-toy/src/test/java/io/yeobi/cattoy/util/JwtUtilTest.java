package io.yeobi.cattoy.util;

import io.jsonwebtoken.Claims;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yeobi
 * @created 2019-11-05
 */
public class JwtUtilTest {

    private static final String SECRET = "12345678901234567890123456789012";

    private static final String TOKEN = "";

    private JwtUtil jwtUtil;

    @Before
    public void setUp() {
        jwtUtil = new JwtUtil(SECRET);
    }

    /**
     * 토큰 생성
     */
    @Test
    public void createToken() {
        String token = jwtUtil.createToken(13L, "테스터");

        assertThat(token).isNotBlank();
    }

    /**
     * 디코딩
     */
    @Test
    public void parseToken() {
        Claims claims = jwtUtil.parseToken(TOKEN);

        assertThat(claims.get("userId", Long.class)).isEqualTo(13L);
        assertThat(claims.get("name", Long.class)).isEqualTo("테스터");
    }

}