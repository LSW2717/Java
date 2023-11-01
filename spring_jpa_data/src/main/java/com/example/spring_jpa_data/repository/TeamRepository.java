package com.example.spring_jpa_data.repository;

import com.example.spring_jpa_data.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
