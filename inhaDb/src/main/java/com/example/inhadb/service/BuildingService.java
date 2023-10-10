package com.example.inhadb.service;


import com.example.inhadb.entity.Building;
import com.example.inhadb.repository.BuildingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BuildingService {

    private final BuildingRepository buildingRepository;

    @Transactional
    public Long save(Building building){
        buildingRepository.save(building);
        return building.getId();
    }

    public Building findOne(Long buildingId){
        return buildingRepository.findOne(buildingId);
    }

    public List<Building> findBuildings(){
        return buildingRepository.findAll();
    }

}
