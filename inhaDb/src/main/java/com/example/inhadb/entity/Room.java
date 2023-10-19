package com.example.inhadb.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Room {
    @Id
//    @GeneratedValue
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Capacity")
    private Long capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_Id")
    private Building building;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_Id")
    private Lecture lecture;

    public void setBuilding(Building building){
        this.building = building;
        building.getRooms().add(this);
    }
    public void setLecture(Lecture lecture){
        this.lecture = lecture;
        lecture.setRoom(this);
    }


}
