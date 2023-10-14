package com.example.inhadb.service;

import com.example.inhadb.entity.Student;
import com.example.inhadb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    // Create
    @Transactional
    public void save(Student student) {
        studentRepository.save(student);
    }

    // Read single
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    // Read all
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // Update
    @Transactional
    public Student update(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));

        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setPhoneNumber(studentDetails.getPhoneNumber());
        student.setMajor(studentDetails.getMajor());
        return studentRepository.save(student);
    }

    // Delete
    @Transactional
    public void delete(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
        studentRepository.delete(student);
    }
}