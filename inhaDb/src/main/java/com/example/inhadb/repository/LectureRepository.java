package com.example.inhadb.repository;


import com.example.inhadb.entity.Lecture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LectureRepository {
    @PersistenceContext
    private final EntityManager em;

    public void save(Lecture lecture){
        em.persist(lecture);
    }

    public Lecture findOne(Long id){
        return em.find(Lecture.class, id);
    }

    public List<Lecture> findAll(){
        return em.createQuery("select l from Lecture l", Lecture.class)
                .getResultList();
    }
}
