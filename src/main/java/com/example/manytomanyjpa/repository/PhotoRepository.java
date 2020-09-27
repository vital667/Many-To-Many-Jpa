package com.example.manytomanyjpa.repository;

import com.example.manytomanyjpa.entity.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Long> {
}
