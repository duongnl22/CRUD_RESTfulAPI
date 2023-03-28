package com.example.duongnl_poly_test.service;

import com.example.duongnl_poly_test.dto.Sub_CategoryDTO;
import com.example.duongnl_poly_test.entity.Sub_Category;
import com.example.duongnl_poly_test.repository.Sub_CategoryRepository;
import com.example.duongnl_poly_test.service.impl.Sub_CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Sub_CategoryServiceImpl implements Sub_CategoryService {
    @Autowired
    private Sub_CategoryRepository subCategoryRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public List<Sub_CategoryDTO> getAllSubCategoryDto() {
        List<Sub_Category> listSubCategory = subCategoryRepository.findAll();

        TypeToken<List<Sub_CategoryDTO>> typeToken = new TypeToken<>() {
        };

        List<Sub_CategoryDTO> listSubCategoryDTO = mapper.map(listSubCategory, typeToken.getType());

        return listSubCategoryDTO;
    }

    @Override
    public List<Sub_CategoryDTO> searchSubCategoryDTO(Long id) {
        List<Sub_Category> searchSubCategory = subCategoryRepository.searchSubCategory(id);

        TypeToken<List<Sub_CategoryDTO>> typeToken = new TypeToken<>() {
        };

        List<Sub_CategoryDTO> searchSubCategoryDTO = mapper.map(searchSubCategory, typeToken.getType());

        return searchSubCategoryDTO;
    }

}
