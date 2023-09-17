package com.example.springbootimage.api;

import com.example.springbootimage.repo.ProductRepository;
import com.example.springbootimage.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(
            @ModelAttribute Product product
    ) {
        return ResponseEntity.ok(productRepository.save(product));
    }

    @PutMapping("/update/{prodId}")
    public ResponseEntity<?> updateProduct(
            @ModelAttribute Product product,
            @PathVariable("prodId") Long prodId
    ) {
        //checking for prod id
        product.setId(prodId);
        return ResponseEntity.ok(productRepository.save(product));
    }

    @GetMapping("/id/{prodId}")
    public ResponseEntity<?> getProducts(
            @PathVariable("prodId") Long id
    ) {
        return ResponseEntity.ok(productRepository.findById(id));
    }
}
