package io.yeobi.cattoy.dto;

import com.github.dozermapper.core.Mapping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@Data
@Builder
@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor // 전체 매개변수 생성자
public class ProductDto {

    @Mapping("id")
    private Long id;

    @NotBlank   // 유효성 체크
    @Mapping("name")
    private String name;

    @Mapping("maker")
    private String maker;

    @Min(0)
    @Mapping("price")
    private Integer price;

}
