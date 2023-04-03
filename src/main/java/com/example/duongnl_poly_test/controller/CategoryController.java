package com.example.duongnl_poly_test.controller;

import com.example.duongnl_poly_test.dto.CategoryDTO;
import com.example.duongnl_poly_test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService ;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        List<CategoryDTO> listCategoryDTO  = categoryService.getAllCategory();
        return ResponseEntity.ok(listCategoryDTO);
    }
}
