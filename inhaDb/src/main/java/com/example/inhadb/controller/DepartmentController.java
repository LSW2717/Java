package com.example.inhadb.controller;

import com.example.inhadb.entity.Department;
import com.example.inhadb.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/update/department")
    public String listDepartments(Model model){
        List<Department> departments = departmentService.findAll();
        model.addAttribute("department_res", departments);
        model.addAttribute("main_title", "Department Listing");
        return "updateDepartment";
    }

    @PostMapping("/update/department")
    public String updateStudent(@ModelAttribute("department") Department department){
        departmentService.update(department.getId(), department);
        return "redirect:/update/department";
    }
}
