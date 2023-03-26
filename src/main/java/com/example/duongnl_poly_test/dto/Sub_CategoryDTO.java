package com.example.duongnl_poly_test.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Sub_CategoryDTO {
    private Long id;

    private String subCategoryCode;

    private String subCategoryName;

    private CategoryDTO category;
}
