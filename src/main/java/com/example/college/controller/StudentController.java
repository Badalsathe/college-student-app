package com.example.college.controller;

import com.example.college.entity.Student;
import com.example.college.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student save(@RequestBody Student student) {
        return service.save(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/department/{dept}")
    public List<Student> getByDepartment(@PathVariable String dept) {
        return service.getByDepartment(dept);
    }

    @GetMapping("/top")
    public List<Student> getTopGpaStudents() {
        return service.getTopGpaStudents();
    }

    @GetMapping("/age")
    public List<Student> getByAgeRange(@RequestParam int min, @RequestParam int max) {
        return service.getByAgeRange(min, max);
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam String keyword) {
        return service.searchByNameOrEmail(keyword);
    }

    @GetMapping("/count/{dept}")
    public long countByDepartment(@PathVariable String dept) {
        return service.countByDepartment(dept);
    }

    @GetMapping("/avg/{dept}")
    public double avgGpa(@PathVariable String dept) {
        return service.averageGpaByDepartment(dept);
    }
}