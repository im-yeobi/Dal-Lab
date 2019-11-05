package io.yeobi.cattoy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author yeobi
 * @created 2019-11-05
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;

    private String email;

    private String password;

}
