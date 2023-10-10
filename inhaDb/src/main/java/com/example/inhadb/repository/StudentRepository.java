package com.example.inhadb.repository;


import com.example.inhadb.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    @PersistenceContext
    private final EntityManager em;

    public void save(Student student){
        em.persist(student);
    }

    public Student findOne(Long id){
        return em.find(Student.class, id);
    }

    public List<Student> findAll(){
        return em.createQuery("select s from Student s", Student.class)
                .getResultList();
    }
}
