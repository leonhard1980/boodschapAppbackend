package com.example.demo.controller;
import com.example.demo.dto.ProductDto;
import com.example.demo.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestBody String productName){
        return ResponseEntity.created();
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> putProduct(@PathVariable Long id, @RequestBody String productName){
        return ResponseEntity.created();
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id){
        return ResponseEntity.noContent();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> retrieveOrderLine(@PathVariable Long id){
        ProductDto odto = productService.getOrder(id);
        return new ResponseEntity<>(odto, HttpStatus.OK);
    }

}
