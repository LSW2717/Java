package com.example.inhadb.controller;

import com.example.inhadb.entity.Building;
import com.example.inhadb.entity.Department;
import com.example.inhadb.entity.Room;
import com.example.inhadb.entity.Student;
import com.example.inhadb.repository.BuildingRepository;
import com.example.inhadb.repository.DepartmentRepository;
import com.example.inhadb.repository.RoomRepository;
import com.example.inhadb.repository.StudentRepository;
import com.example.inhadb.service.BuildingService;
import com.example.inhadb.service.DepartmentService;
import com.example.inhadb.service.RoomService;
import com.example.inhadb.service.StudentService;
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

    @GetMapping("/select")
    public String showOverview(Model model) {
        List<Building> buildings = buildingService.findBuildings();
        List<Department> departments = departmentService.findDepartments();
        List<Room> rooms = roomService.findRooms();
        List<Student> students = studentService.findStudents();

        model.addAttribute("Building", buildings);
        model.addAttribute("Department", departments);
        model.addAttribute("Room", rooms);
        model.addAttribute("Student", students);

        model.addAttribute("main_title", "Tables in InhaDB");
        model.addAttribute("title1", "Building");
        model.addAttribute("title2", "Department");
        model.addAttribute("title3", "Room");
        model.addAttribute("title4", "Student");

        return "select";
    }

}
