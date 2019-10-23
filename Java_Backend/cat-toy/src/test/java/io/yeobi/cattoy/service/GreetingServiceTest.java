package io.yeobi.cattoy.service;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yeobi
 * @created 2019-10-24
 * @description Greeting application 레이어 테스트
 */
public class GreetingServiceTest {

    private GreetingService greetingService;

    @Before
    public void setUp() {
        greetingService = new GreetingService();
    }

    @Test
    public void getMessage() {
        assertThat(greetingService.getMessage()).isEqualTo("Hello");
    }

}
