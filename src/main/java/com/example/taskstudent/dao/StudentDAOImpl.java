package com.example.taskstudent.dao;

import com.example.taskstudent.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }


    @Override
    public List<Student> findALL() {
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student",Student.class);
        List<Student> student=theQuery.getResultList();
        return student;
    }

    @Override
    public Student findById(int theId) {
        Student theStudent = entityManager.find(Student.class,theId);
        return theStudent;
    }

    @Override
    public Student save(Student theStudent) {
        Student dbStudent= entityManager.merge(theStudent);
        return dbStudent;
    }

    @Override
    public void delete(int theId) {
        Student theStudent = entityManager.find(Student.class,theId);
        entityManager.remove(theStudent);

    }
}
