package com.example.projectboardapp.repository;

import com.example.projectboardapp.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
//board 테이블에 접근하기 위한 창구
public interface BoardRepository extends JpaRepository<Board, Long> {

}
