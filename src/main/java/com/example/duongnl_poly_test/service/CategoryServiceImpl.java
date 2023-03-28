package com.example.duongnl_poly_test.service;

import com.example.duongnl_poly_test.dto.CategoryDTO;
import com.example.duongnl_poly_test.entity.Category;
import com.example.duongnl_poly_test.repository.CategoryRepository;
import com.example.duongnl_poly_test.service.impl.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> listCategory = categoryRepository.findAll();

        TypeToken<List<CategoryDTO>> typeToken = new TypeToken<>() {
        };

        List<CategoryDTO> listCategoryDTO = mapper.map(listCategory, typeToken.getType());

        return listCategoryDTO;
    }
}
