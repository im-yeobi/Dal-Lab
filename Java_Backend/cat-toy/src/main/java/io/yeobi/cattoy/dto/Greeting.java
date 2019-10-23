package io.yeobi.cattoy.dto;

/**
 * @author yeobi
 * @created 2019-10-23
 * @description 데이터를 주고 받기 위한 DTO 객체
 */
public class Greeting {

    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
