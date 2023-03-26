package com.example.duongnl_poly_test.controller;

import com.example.duongnl_poly_test.dto.ProductDTO;
import com.example.duongnl_poly_test.dto.ResponseAPI;
import com.example.duongnl_poly_test.service.impl.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> post(@RequestBody @Valid ProductDTO productDTO) {

        return productService.saveOrUpdate(productDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> put(@RequestBody @Valid ProductDTO productDTO) {

        return productService.saveOrUpdate(productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        return productService.delete(id);
    }

    @GetMapping("/{offset}/{pageSize}")
    public ResponseAPI<Page<ProductDTO>> getProductWithPage(@PathVariable("offset") int offset , @PathVariable("pageSize") int pageSize){
        return productService.getProductWithPage(offset, pageSize);
    }

}
