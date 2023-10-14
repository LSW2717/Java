package com.example.inhadb.service;

import com.example.inhadb.entity.Building;
import com.example.inhadb.entity.Employee;
import com.example.inhadb.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    // Create
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Read single
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    // Read all
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    // Update
    @Transactional
    public Employee update(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        employee.setName(employeeDetails.getName());
        employee.setPosition(employeeDetails.getPosition());
        // ... 필요한 경우, 다른 필드들의 업데이트 로직 추가...

        return employeeRepository.save(employee);
    }

    // Delete
    @Transactional
    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        employeeRepository.delete(employee);
    }

    // Set building for the employee
    public Employee setBuilding(Long employeeId, Building building) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        employee.setBuilding(building);
        return employeeRepository.save(employee);
    }
}