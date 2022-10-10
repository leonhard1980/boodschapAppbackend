package com.example.demo.services;

import com.example.demo.adapters.ProductAdapter;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Collection<ProductDto> getAll() {
        var products = productRepository.findAll();
        ArrayList<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            if (product != null)
                productDtos.add(ProductAdapter.ToProductDto(product));
        }
        return productDtos;
    }

    public ProductDto getById(Long id) {
        var product = productRepository.findById(id);
        if (product == null)
            return null;
        return ProductAdapter.ToProductDto(product.get());
    }
}
