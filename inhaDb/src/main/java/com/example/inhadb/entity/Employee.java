package com.example.inhadb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Employee {
    @Id
//    @GeneratedValue
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Position")
    private String position;

    @ManyToOne
    @JoinColumn(name = "building_Id")
    private Building building;
}
