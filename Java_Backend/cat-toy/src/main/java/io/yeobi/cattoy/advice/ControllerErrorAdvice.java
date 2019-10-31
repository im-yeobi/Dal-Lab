package io.yeobi.cattoy.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;

/**
 * @author yeobi
 * @created 2019-10-31
 * @description 에러에 대한 처리 담당
 */
@ControllerAdvice
public class ControllerErrorAdvice {

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleNotFound() {
        return ResponseEntity.notFound().build();
    }

}
