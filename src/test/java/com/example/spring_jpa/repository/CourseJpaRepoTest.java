package com.example.spring_jpa.repository;

import com.example.spring_jpa.entity.Course;
import com.example.spring_jpa.entity.Student;
import com.example.spring_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseJpaRepoTest {

    @Autowired
    private CourseJpaRepo courseJpaRepo;


    @Test
    public void printAllCourse(){
        List<Course> courses= courseJpaRepo.findAll();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher= Teacher.builder()
                .first_name("Priyanka")
                .last_name("Singh")
                .build();

        Course course= Course.builder()
                .title("python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseJpaRepo.save(course);
    }

    @Test
    public  void findAllPagination(){

        Pageable firstPageWithThreeRecords= PageRequest.of(0,3);
        Pageable secondPageWithThreeRecords= PageRequest.of(0,2);

        List<Course> courses= courseJpaRepo.findAll(firstPageWithThreeRecords).getContent();
        
        long totalElements=courseJpaRepo.findAll(firstPageWithThreeRecords).getTotalElements();
        
        long totalPages= courseJpaRepo.findAll(firstPageWithThreeRecords).getTotalPages();


        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting(){

        Pageable sortByTitle= PageRequest.of(0,2, Sort.by("title"));

        Pageable sortByCreditDesc= PageRequest.of(0,2,Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc= PageRequest.of(0,2,Sort.by("title").descending().and(Sort.by("credit")));


        List<Course>  courses= courseJpaRepo.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void printByTitleContaining(){
        Pageable firstPageTenRecords=PageRequest.of(0,10);

        List<Course> courses= courseJpaRepo.findByTitleContaining("D",firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher=Teacher.builder()
                .first_name("Nashim")
                .last_name("Islam")
                .build();

        Student student=Student.builder()
                .firstName("Faruk")
                .lastName("Islam")
                .emailId("fa@gmail.com")
                .build();

        Course course=Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);


        courseJpaRepo.save(course);
    }

}