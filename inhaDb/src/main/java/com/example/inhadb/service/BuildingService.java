package com.example.inhadb.service;


import com.example.inhadb.entity.Building;
import com.example.inhadb.entity.Department;
import com.example.inhadb.entity.Employee;
import com.example.inhadb.entity.Room;
import com.example.inhadb.repository.BuildingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BuildingService {

    private final BuildingRepository buildingRepository;
    // Create
    @Transactional
    public Building save(Building building) {
        return buildingRepository.save(building);
    }

    // Read single
    public Optional<Building> findById(Long id) {
        return buildingRepository.findById(id);
    }

    // Read all
    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    // Update
    @Transactional
    public Building update(Long id, Building buildingDetails) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Building not found for this id :: " + id));

        building.setName(buildingDetails.getName());
        // 필드 업데이트 로직...
        // 연관된 엔티티를 수정하는 경우 주의가 필요합니다. 연관된 엔티티는 주로 해당 엔티티의 서비스나 리포지토리를 통해 수정해야 합니다.

        return buildingRepository.save(building);
    }

    // Delete
    public void delete(Long id) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Building not found for this id :: " + id));
        buildingRepository.delete(building);
    }

    // Add department to building
    public void addDepartment(Long buildingId, Department department) {
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new ResourceNotFoundException("Building not found for this id :: " + buildingId));
        building.addDepartment(department);
        // department 리포지토리를 사용하여 department를 저장할 수도 있습니다.
    }

    // Add employee to building
    public void addEmployee(Long buildingId, Employee employee) {
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new ResourceNotFoundException("Building not found for this id :: " + buildingId));
        building.addEmployee(employee);
        // employee 리포지토리를 사용하여 employee를 저장할 수도 있습니다.
    }

    // Add room to building
    public void addRoom(Long buildingId, Room room) {
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new ResourceNotFoundException("Building not found for this id :: " + buildingId));
        building.addRoom(room);
        // room 리포지토리를 사용하여 room를 저장할 수도 있습니다.
    }
}