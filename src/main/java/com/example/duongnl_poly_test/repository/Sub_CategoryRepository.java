package com.example.duongnl_poly_test.repository;

import com.example.duongnl_poly_test.entity.Sub_Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Sub_CategoryRepository extends JpaRepository<Sub_Category, Long> {

    @Query("SELECT a FROM Sub_Category a WHERE a.category.id = ?1")
    List<Sub_Category> searchSubCategory(Long id);
}
