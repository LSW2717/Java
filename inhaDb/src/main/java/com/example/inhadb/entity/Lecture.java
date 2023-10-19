package com.example.inhadb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Lecture {
    @Id
//    @GeneratedValue
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Professor")
    private String professor;

    @Column(name = "Number_of_Participants")
    private Long numberOfParticipants;

    @OneToOne(mappedBy = "lecture", cascade = CascadeType.ALL)
    private Room room;
}
