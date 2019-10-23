package io.yeobi.cattoy.dto;

import lombok.Data;

/**
 * @author yeobi
 * @created 2019-10-23
 * @description 데이터를 주고 받기 위한 DTO 객체
 */
@Data   // Lombok 플러그인의 @Data 어노테이션 적용하여 getter/setter 사용 (컴파일 단계에서 자동 생성됨)
public class GreetingDto {

    private String name;
    private String message;
}
