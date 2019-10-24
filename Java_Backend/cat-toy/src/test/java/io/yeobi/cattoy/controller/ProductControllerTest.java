package io.yeobi.cattoy.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yeobi
 * @created 2019-10-24
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * GET /products
     */
    @Test
    public void list() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk());
    }

}