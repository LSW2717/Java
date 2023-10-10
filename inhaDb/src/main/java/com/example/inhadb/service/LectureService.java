package com.example.inhadb.service;

import com.example.inhadb.entity.Lecture;
import com.example.inhadb.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    @Transactional
    public Long save(Lecture lecture){
        lectureRepository.save(lecture);
        return lecture.getId();
    }

    public Lecture findOne(Long lectureId){
        return lectureRepository.findOne(lectureId);
    }

    public List<Lecture> findLectures(){
        return lectureRepository.findAll();
    }

}
