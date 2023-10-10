package com.example.inhadb.service;

import com.example.inhadb.entity.Student;
import com.example.inhadb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public Long save(Student student){
        studentRepository.save(student);
        return student.getId();
    }

    public Student findOne(Long studentId){
        return studentRepository.findOne(studentId);
    }

    public List<Student> findStudents(){
        return studentRepository.findAll();
    }

}
