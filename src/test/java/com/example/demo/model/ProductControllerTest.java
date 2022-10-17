package com.example.demo.model;

import com.example.demo.controller.ProductController;
import com.example.demo.dto.ProductDto;
import com.example.demo.security.JwtService;
import com.example.demo.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    JwtService jwtService;

    @MockBean
    ProductService productService;

    @Test
    @WithMockUser(username="testuser", roles = "USER")
    void shouldRetrieveCorrectOrder() throws Exception {

        ProductDto odto = new ProductDto();
        odto.description = "Friese worteltjes van het land";
        odto.productName = "worteltjes";
        odto.price = 5.5;
        odto.discountPrice = 4.5;

        Mockito.when(productService.getOrderLine(123).thenReturn(odto));

        this.mockMvc
                .perform(MockMvcRequestBuilders.get())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", is("Friese worteltjes van het land")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName", is("worteltjes")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", is(5.5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.discountPrice", is(4.5)))




    }

}