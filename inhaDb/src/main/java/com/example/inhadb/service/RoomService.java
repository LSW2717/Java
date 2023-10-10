package com.example.inhadb.service;

import com.example.inhadb.entity.Room;
import com.example.inhadb.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    @Transactional
    public Long save(Room room){
        roomRepository.save(room);
        return room.getId();
    }

    public Room findOne(Long roomId){
        return roomRepository.findOne(roomId);
    }

    public List<Room> findRooms(){
        return roomRepository.findAll();
    }

}
