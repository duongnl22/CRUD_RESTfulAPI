package com.example.duongnl_poly_test.service;

import com.example.duongnl_poly_test.dto.BrandDTO;
import com.example.duongnl_poly_test.entity.Brand;
import com.example.duongnl_poly_test.repository.BrandRepository;
import com.example.duongnl_poly_test.service.impl.BrandService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<BrandDTO> getAllBrand() {
        List<Brand> listBrand = brandRepository.findAll();

        List<BrandDTO> listBrandDTO = new ArrayList<>();

        mapper.map(listBrand, listBrandDTO.stream().collect(Collectors.toList()));
        return listBrandDTO;
    }
}
