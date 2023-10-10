package com.example.inhadb.service;

import com.example.inhadb.entity.Club;
import com.example.inhadb.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClubService {

    private final ClubRepository clubRepository;

    @Transactional
    public Long save(Club club){
        clubRepository.save(club);
        return club.getId();
    }

    public Club findOne(Long clubId){
        return clubRepository.findOne(clubId);
    }

    public List<Club> findClubs(){
        return clubRepository.findAll();
    }

}
