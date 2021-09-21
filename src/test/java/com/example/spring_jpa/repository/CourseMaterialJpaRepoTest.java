package com.example.spring_jpa.repository;

import com.example.spring_jpa.entity.Course;
import com.example.spring_jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialJpaRepoTest {

    @Autowired
     private CourseMaterialJpaRepo courseMaterialJpaRepo;

    @Test
    public  void saveCourseMaterial(){
        Course course= Course.builder()
                .title("DSA")
                .credit(6)
                .build();


        CourseMaterial courseMaterial= CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        courseMaterialJpaRepo.save(courseMaterial);
    }
    
    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterials=courseMaterialJpaRepo.findAll();

        System.out.println("courseMaterials = " + courseMaterials);
    }


}