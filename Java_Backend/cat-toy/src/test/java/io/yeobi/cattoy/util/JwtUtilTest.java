package io.yeobi.cattoy.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yeobi
 * @created 2019-11-05
 */
public class JwtUtilTest {

    private static final String SECRET = "12345678901234567890123456789012";

    @Test
    public void createToken() {
        JwtUtil jwtUtil = new JwtUtil(SECRET);

        String token = jwtUtil.createToken(13L, "테스터");

        assertThat(token).isNotBlank();
    }

}