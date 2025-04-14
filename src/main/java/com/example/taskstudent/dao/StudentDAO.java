package com.example.taskstudent.dao;

import com.example.taskstudent.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findALL();

    Student findById(int theId);

    Student save(Student theStudent);

    void delete(int theId);
}
