package com.example.college.repository;

import com.example.college.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByDepartment(String department);
    List<Student> findByGpaGreaterThan(double gpa);
    List<Student> findByAgeBetween(int min, int max);
    List<Student> findByGender(String gender);
    List<Student> findByNameContaining(String name);
    List<Student> findTop3ByOrderByGpaDesc();
    List<Student> findByEmailEndingWith(String suffix);

    @Query("SELECT s FROM Student s WHERE s.name LIKE %:keyword% OR s.email LIKE %:keyword%")
    List<Student> searchByNameOrEmail(String keyword);

    @Query("SELECT COUNT(s) FROM Student s WHERE s.department = :dept")
    long countByDepartment(String dept);

    @Query("SELECT AVG(s.gpa) FROM Student s WHERE s.department = :dept")
    Double averageGpaByDepartment(String dept);
}