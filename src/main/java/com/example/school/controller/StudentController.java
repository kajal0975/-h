package com.example.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.school.model.Student;
import com.example.school.service.StuentH2Service;

import java.util.ArrayList;

@RestController
public class StudentController {

    @Autowired
    private StudentH2Serivce studentH2service;

    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        return studentH2service.getStudents();
    }    

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId) {
        return studentH2service.getStudentById(studentId);
    }
    @PostMapping("/students")
    public Student addSingleStudent(@RequestBody Student student) {
        return studentH2Serive.addSingleStudent(student);
    }

    @PostMapping("/students/bulk")
    public String addMultipleStudents(@RequestBody ArrayList<Student> studentsList) {
        return studentH2service.addMultipleStudents(studentsList);
    }

    @PutMapping("/students/{studentId}")
    public Student updatStudent(@PathVariable("studentId") int studentId, @RequestBody Student student) {
        return studentH2service.updatStudent(studentId, student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentH2service.deleteStudent(studentId);
    }
}        