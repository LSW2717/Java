package com.example.inhadb.repository;


import com.example.inhadb.entity.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RoomRepository {
    @PersistenceContext
    private final EntityManager em;

    public void save(Room room){
        em.persist(room);
    }

    public Room findOne(Long id){
        return em.find(Room.class, id);
    }

    public List<Room> findAll(){
        return em.createQuery("select r from Room r", Room.class)
                .getResultList();
    }
}
