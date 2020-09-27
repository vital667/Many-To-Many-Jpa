package com.example.manytomanyjpa.repository;


import com.example.manytomanyjpa.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
