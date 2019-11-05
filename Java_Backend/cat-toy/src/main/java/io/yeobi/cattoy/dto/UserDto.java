package io.yeobi.cattoy.dto;

import com.github.dozermapper.core.Mapping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yeobi
 * @created 2019-11-05
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @Mapping("name")
    private String name;

    @Mapping("email")
    private String email;

    @Mapping("password")
    private String password;

}
