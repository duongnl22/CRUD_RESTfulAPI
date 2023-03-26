package com.example.duongnl_poly_test.repository;

import com.example.duongnl_poly_test.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand ,Long> {
}
