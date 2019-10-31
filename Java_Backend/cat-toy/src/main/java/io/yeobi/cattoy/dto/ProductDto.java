package io.yeobi.cattoy.dto;

import com.github.dozermapper.core.Mapping;
import lombok.Data;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@Data
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
