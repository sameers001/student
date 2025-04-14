package com.example.taskstudent.rest;


import com.example.taskstudent.entity.Student;
import com.example.taskstudent.service.StudentService;
import com.example.taskstudent.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class StudentRestController {
    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService theStudentService){

        studentService = theStudentService;
    }

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findALL();
    }


    @GetMapping("/students/{studentId}")
    public Student findById(@PathVariable int studentId) {
        Student theStudent = studentService.findById(studentId);
        if(theStudent == null) {
            throw new RuntimeException("Student with id " + studentId + " not found");
        }
        return theStudent;
    }


    @PostMapping("/students")
    public Student addStudent(@RequestBody Student theStudent) {

        theStudent.setId(0);

        Student dbStudent = studentService.save(theStudent);
        return dbStudent;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student theStudent) {
        Student dbStudent = studentService.save(theStudent);
        return dbStudent;
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable int studentId) {
        Student theStudent = studentService.findById(studentId);

        if(theStudent == null) {
            throw new RuntimeException("Student with id " + studentId + " not found");
        }
        studentService.delete(studentId);

        return "Deleted Student with id " + studentId;
    }

}
