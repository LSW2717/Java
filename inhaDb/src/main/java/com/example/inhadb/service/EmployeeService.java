package com.example.inhadb.service;

import com.example.inhadb.entity.Employee;
import com.example.inhadb.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional
    public Long save(Employee employee){
        employeeRepository.save(employee);
        return employee.getId();
    }

    public Employee findOne(Long employeeId){
        return employeeRepository.findOne(employeeId);
    }

    public List<Employee> findEmployees(){
        return employeeRepository.findAll();
    }
}
