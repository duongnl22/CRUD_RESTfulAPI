package com.example.duongnl_poly_test.service.impl;

import com.example.duongnl_poly_test.dto.Sub_CategoryDTO;

import java.util.List;

public interface Sub_CategoryService {
    List<Sub_CategoryDTO> getAllSubCategoryDto();

    List<Sub_CategoryDTO> searchSubCategoryDTO(Long id);
}
