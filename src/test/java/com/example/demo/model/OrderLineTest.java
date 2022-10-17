package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderLineTest {

    @Test
    void shouldcalculateAmount() {
        // arrange
        OrderLine o = new Order();

        // act
        double result = o.calculateAmount(wat hierin moet is onduidelijk);

        //assert
        assertEquals(120, result);
    }

  @Test
    void shouldgetOriginalPrice(){
        OrderLine o = new OrderLine(hier moet weer iets in en de originalPrice van 4.5);
        String result = o.getOriginalPrice();
        assertEquals(4.5, result);
    }


    @Test
    void getAmount() {
        //arrange
        OrderLine o = new OrderLine(1);
        //act
        int result = o.getAmount();
        //assert
        assertEquals(1, result);
    }
}