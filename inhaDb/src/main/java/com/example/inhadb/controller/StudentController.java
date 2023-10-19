package com.example.inhadb.controller;

import com.example.inhadb.entity.Student;
import com.example.inhadb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("student", new Student());
        return "home";
    }

    @PostMapping("/")
    public String handleSubmit(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/update/student")
    public String listStudents(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("student_res", students);
        model.addAttribute("main_title", "Student Listing");
        return "updateStudent";
    }

    @PostMapping("/update/student")
    public String updateStudent(@ModelAttribute("student") Student student){
        studentService.update(student.getId(), student);
        return "redirect:/update/student";
    }
}
