package com.example.inhadb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Building {
    @Id
//    @GeneratedValue
    private Long id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "building")
    private List<Department> departments = new ArrayList<>();

    @OneToMany(mappedBy = "building")
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "building")
    private List<Room> rooms = new ArrayList<>();

    public void addDepartment(Department department){
        departments.add(department);
        department.setBuilding(this);
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
        employee.setBuilding(this);
    }
    public void addRoom(Room room){
        rooms.add(room);
        room.setBuilding(this);
    }
}
