package com.example.duongnl_poly_test.entity;

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
@Entity
@Table(name = "sub_category")
public class Sub_Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sub_category_code")
    private String subCategoryCode;

    @Column(name = "sub_category_name")
    private String subCategoryName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id" , referencedColumnName = "id")
    private Category category;
}
