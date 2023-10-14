package com.example.inhadb.controller;

import com.example.inhadb.entity.*;
import com.example.inhadb.repository.BuildingRepository;
import com.example.inhadb.repository.DepartmentRepository;
import com.example.inhadb.repository.RoomRepository;
import com.example.inhadb.repository.StudentRepository;
import com.example.inhadb.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OverviewController {
    private final BuildingService buildingService;
    private final DepartmentService departmentService;
    private final RoomService roomService;
    private final StudentService studentService;
    private final LectureService lectureService;

    @GetMapping("/select")
    public String showOverview(Model model) {
        List<Building> buildings = buildingService.findAll();
        List<Department> departments = departmentService.findAll();
        List<Room> rooms = roomService.findAll();
        List<Student> students = studentService.findAll();
        List<Lecture> lectures = lectureService.findAll();

        model.addAttribute("Building", buildings);
        model.addAttribute("Department", departments);
        model.addAttribute("Room", rooms);
        model.addAttribute("Student", students);
        model.addAttribute("Lecture", lectures);

        model.addAttribute("main_title", "Tables in InhaDB");
        model.addAttribute("title1", "Building");
        model.addAttribute("title2", "Department");
        model.addAttribute("title3", "Room");
        model.addAttribute("title4", "Student");
        model.addAttribute("title5", "Lecture");

        return "select";
    }

}
