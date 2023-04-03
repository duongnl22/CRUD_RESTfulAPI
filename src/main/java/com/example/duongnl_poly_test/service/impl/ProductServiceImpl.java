package com.example.duongnl_poly_test.service.impl;

import com.example.duongnl_poly_test.dto.ProductDTO;
import com.example.duongnl_poly_test.dto.ResponseAPI;
import com.example.duongnl_poly_test.entity.Product;
import com.example.duongnl_poly_test.exception.NotFoundException;
import com.example.duongnl_poly_test.repository.ProductRepository;
import com.example.duongnl_poly_test.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        List<Product> listProduct = productRepository.findAll();

        TypeToken<List<ProductDTO>> typeToken = new TypeToken<>() {
        };
        List<ProductDTO> listProductDTO = mapper.map(listProduct, typeToken.getType());

        return ResponseEntity.ok(listProductDTO);
    }

    @Override
    public ResponseEntity<ProductDTO> findById(Long id) {
        if (!productRepository.existsById(id))
            throw new NotFoundException("Không có đối tượng cần tìm !!!");
        Product product = productRepository.findById(id).get();
        ProductDTO productDTO = mapper.map(product, ProductDTO.class);
        return ResponseEntity.ok(productDTO);

    }


    @Override
    public ResponseEntity<ProductDTO> saveOrUpdate(ProductDTO productDTO) {
        Product product = mapper.map(productDTO, Product.class);

        Product productSave = productRepository.save(product);

        mapper.map(productSave, productDTO);

        return ResponseEntity.ok(productDTO);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        if (!productRepository.existsById(id))
            throw new NotFoundException("Không có đối tượng cần tìm !!!");

        productRepository.deleteProductBrand(id);
        productRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseAPI<Page<ProductDTO>> getProductWithPage(int offset, int pageSize) {
        Page<Product> productPage = productRepository.findAll(PageRequest.of(offset, pageSize));

        TypeToken<Page<ProductDTO>> typeToken = new TypeToken<>() {
        };
        Page<ProductDTO> productDTOPage = mapper.map(productPage, typeToken.getType());

        return new ResponseAPI<>(productDTOPage.getSize(), productDTOPage);
    }


}
