package com.example.spring_jpa_data.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Team(String name){
        this.name = name;
    }


}
