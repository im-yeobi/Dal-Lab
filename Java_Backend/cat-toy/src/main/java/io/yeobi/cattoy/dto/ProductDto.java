package io.yeobi.cattoy.dto;

import com.github.dozermapper.core.Mapping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Mapping("name")
    private String name;

    @Mapping("maker")
    private String maker;

    @Mapping("price")
    private Integer price;

}
