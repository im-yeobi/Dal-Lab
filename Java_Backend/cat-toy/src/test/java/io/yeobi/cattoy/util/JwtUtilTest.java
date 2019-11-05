package io.yeobi.cattoy.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yeobi
 * @created 2019-11-05
 */
public class JwtUtilTest {

    @Test
    public void createToken() {
        JwtUtil jwtUtil = new JwtUtil();

        String token = jwtUtil.createToken(13L, "테스터");

        assertThat(token).isNotBlank();
    }

}