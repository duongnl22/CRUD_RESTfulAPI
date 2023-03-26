package com.example.duongnl_poly_test.repository;

import com.example.duongnl_poly_test.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status , Long> {

}
