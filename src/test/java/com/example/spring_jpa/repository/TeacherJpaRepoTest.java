package com.example.spring_jpa.repository;

import com.example.spring_jpa.entity.Course;
import com.example.spring_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherJpaRepoTest {


    @Autowired
    private TeacherJpaRepo teacherJpaRepo;

    @Test
    public  void  saveTeacher(){

        Course courseDBA= Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course courseJava= Course.builder()
                .title("JAVA")
                .credit(5)
                .build();


        Teacher teacher=Teacher.builder()
                .first_name("Mujahid")
                .last_name("Islam")
                //.courses(List.of(courseDBA,courseJava))
                .build();

        teacherJpaRepo.save(teacher);
    }


}