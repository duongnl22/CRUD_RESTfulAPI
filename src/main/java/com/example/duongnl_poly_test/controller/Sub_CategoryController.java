package com.example.duongnl_poly_test.controller;

import com.example.duongnl_poly_test.dto.Sub_CategoryDTO;
import com.example.duongnl_poly_test.service.impl.Sub_CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/subcategory")
public class Sub_CategoryController {

    @Autowired
    private Sub_CategoryService subCategoryService;

    @GetMapping
    public ResponseEntity<List<Sub_CategoryDTO>> getAllSbuCategory(){
        List<Sub_CategoryDTO> listSubCategoryDTO = subCategoryService.getAllSubCategoryDto();
        return  ResponseEntity.ok(listSubCategoryDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Sub_CategoryDTO>> searchSubCategory(@PathVariable("id") Long id){
        List<Sub_CategoryDTO> searchSubCategoryDTO = subCategoryService.searchSubCategoryDTO(id);
        return ResponseEntity.ok(searchSubCategoryDTO);
    }
}
