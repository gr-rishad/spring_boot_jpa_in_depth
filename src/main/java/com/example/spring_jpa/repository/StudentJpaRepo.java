package com.example.spring_jpa.repository;

import com.example.spring_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentJpaRepo  extends JpaRepository<Student,Long> {



    public List<Student> findByFirstName(String firstName);


    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);


    // JPQL
    @Query("SELECT s from Student s where s.emailId= ?1")
    Student getStudentByEmailAddress(String email);

    //JPQL
    @Query("SELECT s.firstName FROM Student s WHERE s.emailId= ?1")
    String getStudentFirstNameByEmailAddress(String email);

    // sql
    @Query(nativeQuery =true,value ="SELECT first_name,last_name FROM schooldb.tbl_student WHERE email_address= ?1")
    List<String>  getStudentByEmailAddressNative(String email);

    // SQL Named Parameter
    @Query(nativeQuery =true,value ="SELECT first_name,last_name FROM schooldb.tbl_student WHERE email_address= :email")
    List<String>  getStudentByEmailAddressNativeParam(String email);

    // update
    @Modifying
    @Transactional
    @Query(
            nativeQuery = true,
            value = "UPDATE tbl_student SET first_name = :firstName WHERE email_address= :emailId"
    )
    int updateStudentNameByEmailId(@Param("firstName") String firstName, @Param("emailId") String emailId);

}
