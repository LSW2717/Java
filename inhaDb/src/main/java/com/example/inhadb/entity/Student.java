package com.example.inhadb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Student {
    @Id
//    @GeneratedValue
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone_number")
    private String phoneNumber;

    @Column(name = "Major")
    private String major;

    @ManyToOne
    @JoinColumn(name = "Department_Id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "club_Id")
    private Club club;

    public void setDepartment(Department department){
        this.department = department;
        department.getStudents().add(this);
    }
    public void setClub(Club club){
        this.club = club;
        club.getStudents().add(this);
    }

}
