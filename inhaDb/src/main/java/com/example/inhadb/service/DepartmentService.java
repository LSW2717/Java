package com.example.inhadb.service;

import com.example.inhadb.entity.Building;
import com.example.inhadb.entity.Department;
import com.example.inhadb.entity.Student;
import com.example.inhadb.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    // Create
    @Transactional
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    // Read single
    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    // Read all
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    // Update
    @Transactional
    public Department update(Long id, Department departmentDetails) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + id));

        department.setName(departmentDetails.getName());
        department.setEmail(departmentDetails.getEmail());
        department.setPhoneNumber(departmentDetails.getPhoneNumber());
        // ... 필요한 경우, 다른 필드들의 업데이트 로직 추가...

        return departmentRepository.save(department);
    }

    // Delete
    @Transactional
    public void delete(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + id));
        departmentRepository.delete(department);
    }

    // Add a student to the department
    public void addStudent(Long departmentId, Student student) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));
        department.addStudent(student);
        // student 리포지토리를 사용하여 student 엔티티를 저장할 수도 있습니다.
    }

    // Set building for the department
    public void setBuilding(Long departmentId, Building building) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));
        department.setBuilding(building);
        // building 리포지토리를 사용하여 building 엔티티를 저장할 수도 있습니다.
    }
}