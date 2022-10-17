package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldgetProductName() {
        //arrange
        Product o = new Product("worteltjes", 5, "worteltjesbeschrijving")
        //act
        String result = o.getProductName();
        //assert
        assertEquals("worteltjes", result);

    }

    @Test
    public void shouldChangeProductName(){
        //arrange
        Product p = new Product("worteltjes");
        //act
        p.setProductName("boontjes");
        //assert
        String expected = "worteltjes";
        String actual = p.getProductName();
        assertEquals(expected, actual);


    }

}