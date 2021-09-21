package com.example.spring_jpa.repository;

import com.example.spring_jpa.entity.Guardian;
import com.example.spring_jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentJpaRepoTest {

    @Autowired
    private StudentJpaRepo studentJpaRepo;


    @Test
    public void saveStudent(){
        Student student=Student.builder()
                .emailId("g.rishad@gmail.com")
                .firstName("Golam Rabbani")
                .lastName("Rishad")
                //.guardianName("ABC")
               // .guardianMobile("0000000")
                //.guardianEmail("abc@gmail.com")
                .build();

        studentJpaRepo.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> students= studentJpaRepo.findAll();
        System.out.println("students = " + students);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian=Guardian.builder()
                .email("la@gmail.com")
                .mobile("000011112222").name("LKJ")
                .build();

        Student student=Student.builder()
                .firstName("Golam")
                .lastName("Rabbani")
                .emailId("gr.rishad@gmail.com")
                .guardian(guardian)
                .build();

        studentJpaRepo.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students= studentJpaRepo.findByFirstName("Golam");
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students= studentJpaRepo.findByFirstNameContaining("Gol");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students=studentJpaRepo.findByGuardianName("ABC");

        System.out.println("students = " + students);
    }
    
    @Test
    public void printStudentByEmailAddress(){
        Student students=studentJpaRepo.getStudentByEmailAddress("gr.rishad@gmail.com");

        System.out.println("student = " + students);
    }
    
    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstName= studentJpaRepo.getStudentFirstNameByEmailAddress("gr.rishad@gmail.com");

        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        List <String> student= studentJpaRepo.getStudentByEmailAddressNative("gr.rishad@gmail.com");

        System.out.println("student = " + student);
    }
    
    @Test
    public void printGetStudentByEmailAddressNativeParam(){
        List <String> student= studentJpaRepo.getStudentByEmailAddressNativeParam("gr.rishad@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentJpaRepo.updateStudentNameByEmailId("GOLAM RABBANI ","gr.rishad@gmail.com");
    }

}