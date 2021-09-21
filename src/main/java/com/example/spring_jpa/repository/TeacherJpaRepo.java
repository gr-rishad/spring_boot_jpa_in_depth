package com.example.spring_jpa.repository;

import com.example.spring_jpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherJpaRepo extends JpaRepository<Teacher,Long> {
}
