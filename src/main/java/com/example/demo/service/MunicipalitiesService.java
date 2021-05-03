package com.example.demo.service;

import com.example.demo.dao.MunicipalityRepository;
import com.example.demo.dto.MunicipalityDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalitiesService {
    private MunicipalityRepository municipalityRepository;

    @Autowired
    public MunicipalitiesService(MunicipalityRepository municipalityRepository) {
        this.municipalityRepository = municipalityRepository;
    }

    public List<MunicipalityDataDto> getMunicipalityByDepartment(Integer departmentId) {
        return municipalityRepository.getMunicipalitiesByDepartmentId(departmentId);
    }
}
