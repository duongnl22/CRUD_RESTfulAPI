package com.example.duongnl_poly_test.repository;

import com.example.duongnl_poly_test.entity.Category;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category ,Long> {
}
