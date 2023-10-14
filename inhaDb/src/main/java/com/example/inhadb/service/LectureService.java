package com.example.inhadb.service;

import com.example.inhadb.entity.Lecture;
import com.example.inhadb.entity.Room;
import com.example.inhadb.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;
    // Create
    @Transactional
    public Lecture save(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    // Read single
    public Optional<Lecture> findById(Long id) {
        return lectureRepository.findById(id);
    }

    // Read all
    public List<Lecture> findAll() {
        return lectureRepository.findAll();
    }

    // Update
    @Transactional
    public Lecture update(Long id, Lecture lectureDetails) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lecture not found for this id :: " + id));

        lecture.setName(lectureDetails.getName());
        lecture.setProfessor(lectureDetails.getProfessor());
        lecture.setNumberOfParticipants(lectureDetails.getNumberOfParticipants());
        // ... 필요한 경우, 다른 필드들의 업데이트 로직 추가...

        return lectureRepository.save(lecture);
    }

    // Delete
    @Transactional
    public void delete(Long id) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lecture not found for this id :: " + id));
        lectureRepository.delete(lecture);
    }

    // Set room for the lecture
    public Lecture setRoom(Long lectureId, Room room) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new ResourceNotFoundException("Lecture not found for this id :: " + lectureId));
        lecture.setRoom(room);
        return lectureRepository.save(lecture);
    }
}