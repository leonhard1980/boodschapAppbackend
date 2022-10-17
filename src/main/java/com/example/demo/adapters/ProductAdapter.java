package com.example.demo.adapters;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;

public class ProductAdapter {
    public static ProductDto ToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.productName = product.getProductName();
        productDto.price = product.getPrice();
        // productDto.discountPrice = pro
        productDto.description = product.getDescription();
        return productDto;
    }
}
