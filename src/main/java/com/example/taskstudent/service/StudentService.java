package com.example.taskstudent.service;

import com.example.taskstudent.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findALL();

    Student findById(int theId);

    Student save(Student theStudent);

    void delete(int theId);
}
