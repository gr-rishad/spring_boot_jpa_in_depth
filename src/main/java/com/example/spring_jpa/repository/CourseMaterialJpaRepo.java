package com.example.spring_jpa.repository;

import com.example.spring_jpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialJpaRepo extends JpaRepository<CourseMaterial,Long> {
}
