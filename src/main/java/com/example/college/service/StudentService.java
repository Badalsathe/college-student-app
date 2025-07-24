package com.example.college.service;

import com.example.college.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    List<Student> getAll();
    Student getById(Long id);
    void delete(Long id);
    List<Student> getByDepartment(String department);
    List<Student> getTopGpaStudents();
    List<Student> getByAgeRange(int min, int max);
    List<Student> searchByNameOrEmail(String keyword);
    long countByDepartment(String department);
    double averageGpaByDepartment(String department);
}