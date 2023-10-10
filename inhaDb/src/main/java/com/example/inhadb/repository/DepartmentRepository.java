package com.example.inhadb.repository;


import com.example.inhadb.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DepartmentRepository {
    @PersistenceContext
    private final EntityManager em;

    public void save(Department department){
        em.persist(department);
    }

    public Department findOne(Long id){
        return em.find(Department.class, id);
    }

    public List<Department> findAll(){
        return em.createQuery("select d from Department d", Department.class)
                .getResultList();
    }
}
