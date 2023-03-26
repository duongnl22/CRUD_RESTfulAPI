package com.example.duongnl_poly_test.service;

import com.example.duongnl_poly_test.entity.Product;
import com.example.duongnl_poly_test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTest {

    @Autowired
    private ProductRepository productRepository;

//    public APIResponse<List<Product>> getAllProduct() {
//        List<Product> listProduct = productRepository.findAll();
//
//        return new APIResponse<>(listProduct.size(), listProduct);
//    }
//
//    public APIResponse<List<Product>> getProductWithsSort(String attribute) {
//        List<Product> listProduct = productRepository.findAll(Sort.by(Sort.Direction.ASC, attribute));
//        return new APIResponse<>(listProduct.size(), listProduct);
//    }
//
//    public APIResponse<Page<Product>> pagination(int offset, int pageSize) {
//        Page<Product> product = productRepository.findAll(PageRequest.of(offset, pageSize));
//        return new APIResponse<>(product.getSize(), product);
//    }

}
