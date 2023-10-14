package com.example.inhadb.service;

import com.example.inhadb.entity.Club;
import com.example.inhadb.entity.Student;
import com.example.inhadb.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClubService {

    private final ClubRepository clubRepository;

    // Create
    public Club save(Club club) {
        return clubRepository.save(club);
    }

    // Read single
    public Optional<Club> findById(Long id) {
        return clubRepository.findById(id);
    }

    // Read all
    public List<Club> findAll() {
        return clubRepository.findAll();
    }

    // Update
    public Club update(Long id, Club clubDetails) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Club not found for this id :: " + id));

        club.setName(clubDetails.getName());
        // ... 필요한 경우, 다른 필드들의 업데이트 로직 추가...

        return clubRepository.save(club);
    }

    // Delete
    public void delete(Long id) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Club not found for this id :: " + id));
        clubRepository.delete(club);
    }

    // Add a student to the club
    public Club addStudent(Long clubId, Student student) {
        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new ResourceNotFoundException("Club not found for this id :: " + clubId));
        club.getStudents().add(student);
        student.setClub(club); // assuming Student entity has setClub method.
        return clubRepository.save(club);
    }
}