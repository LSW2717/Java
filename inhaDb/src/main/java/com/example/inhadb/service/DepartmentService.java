package com.example.inhadb.service;

import com.example.inhadb.entity.Department;
import com.example.inhadb.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Transactional
    public Long save(Department department){
        departmentRepository.save(department);
        return department.getId();
    }

    public Department findOne(Long departmentId){
        return departmentRepository.findOne(departmentId);
    }

    public List<Department> findDepartments(){
        return departmentRepository.findAll();
    }

}
