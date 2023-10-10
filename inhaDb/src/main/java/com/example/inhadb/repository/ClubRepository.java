package com.example.inhadb.repository;


import com.example.inhadb.entity.Club;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ClubRepository {
    @PersistenceContext
    private final EntityManager em;

    public void save(Club club){
        em.persist(club);
    }

    public Club findOne(Long id){
        return em.find(Club.class, id);
    }

    public List<Club> findAll(){
        return em.createQuery("select c from Club c", Club.class)
                .getResultList();
    }
}
