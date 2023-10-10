package com.example.inhadb.repository;


import com.example.inhadb.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {
    @PersistenceContext
    private final EntityManager em;

    public void save(Employee employee){
        em.persist(employee);
    }

    public Employee findOne(Long id){
        return em.find(Employee.class, id);
    }

    public List<Employee> findAll(){
        return em.createQuery("select e from Employee e", Employee.class)
                .getResultList();
    }
}
