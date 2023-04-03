package com.example.duongnl_poly_test.controller;

import com.example.duongnl_poly_test.dto.BrandDTO;
import com.example.duongnl_poly_test.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandDTO>> getAllBrand() {
        List<BrandDTO> listBrandDTO = brandService.getAllBrand();
        return ResponseEntity.ok(listBrandDTO);
    }
}
