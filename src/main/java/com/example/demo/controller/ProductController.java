package com.example.demo.controller;

import com.example.demo.adapters.ProductAdapter;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<Collection<ProductDto>> getAll() {
        var productDtos = productService.getAll();
        if (productDtos == null || productDtos.size() == 0)
            return (ResponseEntity<Collection<ProductDto>>) ResponseEntity.noContent();
        return ResponseEntity.ok().body(productDtos);
    }

    @GetMapping("/products/@id")
    public ResponseEntity<ProductDto> getById(@RequestParam() Long id) {
        ProductDto product = productService.getById(id);
        if (product == null)
            return (ResponseEntity<ProductDto>) ResponseEntity.noContent();

        return ResponseEntity.ok().body(product);
    }
}
