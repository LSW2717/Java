package com.example.inhadb.controller;

import com.example.inhadb.entity.Student;
import com.example.inhadb.repository.StudentRepository;
import com.example.inhadb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class studentController {

    private final StudentService studentService;

    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("student", new Student());
        return "home";
    }

    @PostMapping("/")
    public String handleSubmit(Student student){
        studentService.save(student);
        return "redirect:/update";
    }

    @GetMapping("/update")
    public String listStudents(Model model){
        List<Student> students = studentService.findStudents();
        model.addAttribute("student_res", students);
        model.addAttribute("main_title", "Student Listing");
        return "updateStudent";
    }

    @PostMapping("/update/student")
    public String updateStudent(Student student){
        studentService.save(student);
        return "redirect:/update";
    }
}
