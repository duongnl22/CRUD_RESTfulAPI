package com.example.duongnl_poly_test.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {


    private Long id;

    @NotBlank(message = "Product Name required !!!")
    private String productName;

    @NotBlank(message = "Color required !!!")
    private String color;

    @NotNull(message = "Quantity required !!!")
    private Long quantity;

    @NotNull(message = "Sell Price required !!")
    private Double sellPrice;

    @NotNull(message = "Origin Price required !!")
    private Double originPrice;

    private String description;

    private StatusDTO status;

    private Sub_CategoryDTO subCategory;

    private List<BrandDTO> brand;

}
