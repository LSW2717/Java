package com.example.inhadb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Department {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "Building_id")
    private Building building;

    @OneToMany(mappedBy = "department")
    private List<Student> students = new ArrayList<>();

    public void setBuilding(Building building){
        this.building = building;
        building.getDepartments().add(this);
    }
    public void addStudent(Student student){
        students.add(student);
        student.setDepartment(this);
    }
}
