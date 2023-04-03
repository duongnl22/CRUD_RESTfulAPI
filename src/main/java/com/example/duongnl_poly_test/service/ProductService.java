package com.example.duongnl_poly_test.service;

import com.example.duongnl_poly_test.dto.ProductDTO;
import com.example.duongnl_poly_test.dto.ResponseAPI;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<List<ProductDTO>> getAllProduct();

    ResponseEntity<ProductDTO> findById(Long id);

    ResponseEntity<ProductDTO> saveOrUpdate(ProductDTO productDTO);

    ResponseEntity<Void> delete(Long id);

    ResponseAPI<Page<ProductDTO>> getProductWithPage(int offset , int pageSize);


}
