package com.example.inhadb.repository;

import com.example.inhadb.entity.Building;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BuildingRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Building building){
        em.persist(building);
    }

    public Building findOne(Long id){
        return em.find(Building.class, id);
    }

    public List<Building> findAll(){
        return em.createQuery("select b from Building b", Building.class)
                .getResultList();
    }


}
