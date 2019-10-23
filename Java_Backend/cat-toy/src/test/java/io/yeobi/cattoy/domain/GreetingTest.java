package io.yeobi.cattoy.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yeobi
 * @created 2019-10-24
 */
public class GreetingTest {

    /**
     * Greeting 이름 없는 경우 테스트
     */
    @Test
    public void getMessage() {
        Greeting greeting = Greeting.builder()
                .name(null)
                .build();

        assertThat(greeting.getMessage()).isEqualTo("Hello");
    }

    /**
     * Greeting 이름 있는 경우 테스트
     */
    @Test
    public void getMessageWithName() {
        Greeting greeting = Greeting.builder()
                .name("yeobi")
                .build();

        assertThat(greeting.getMessage()).isEqualTo("Hello, yeobi");
    }

}
