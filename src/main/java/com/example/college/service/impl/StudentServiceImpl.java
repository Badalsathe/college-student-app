package com.example.college.service.impl;

import com.example.college.entity.Student;
import com.example.college.repository.StudentRepository;
import com.example.college.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    public Student save(Student student) {
        return repository.save(student);
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Student> getByDepartment(String department) {
        return repository.findByDepartment(department);
    }

    public List<Student> getTopGpaStudents() {
        return repository.findTop3ByOrderByGpaDesc();
    }

    public List<Student> getByAgeRange(int min, int max) {
        return repository.findByAgeBetween(min, max);
    }

    public List<Student> searchByNameOrEmail(String keyword) {
        return repository.searchByNameOrEmail(keyword);
    }

    public long countByDepartment(String department) {
        return repository.countByDepartment(department);
    }

    public double averageGpaByDepartment(String department) {
        return repository.averageGpaByDepartment(department);
    }
}