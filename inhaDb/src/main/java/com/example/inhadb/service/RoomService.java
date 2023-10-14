package com.example.inhadb.service;

import com.example.inhadb.entity.Building;
import com.example.inhadb.entity.Lecture;
import com.example.inhadb.entity.Room;
import com.example.inhadb.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    // Create
    @Transactional
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    // Read single
    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    // Read all
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    // Update
    @Transactional
    public Room update(Long id, Room roomDetails) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + id));

        room.setName(roomDetails.getName());
        room.setCapacity(roomDetails.getCapacity());
        // ... 필요한 경우, 다른 필드들의 업데이트 로직 추가...

        return roomRepository.save(room);
    }

    // Delete
    @Transactional
    public void delete(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + id));
        roomRepository.delete(room);
    }

    // Set building for the room
    public Room setBuilding(Long roomId, Building building) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + roomId));
        room.setBuilding(building);
        return roomRepository.save(room);
    }

    // Set lecture for the room
    public Room setLecture(Long roomId, Lecture lecture) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + roomId));
        room.setLecture(lecture);
        return roomRepository.save(room);
    }
}