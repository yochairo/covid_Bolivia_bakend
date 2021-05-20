package com.example.demo.service;


import com.example.demo.dao.DashboardRepository;
import com.example.demo.dao.DataRepository;
import com.example.demo.dao.DepartmentRepository;
import com.example.demo.domain.Departments;
import com.example.demo.dto.DashboardDataDto;
import com.example.demo.dto.DashboardDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {
    private final DashboardRepository dashboardRepository;
    private final DataRepository dataRepository;
    private final DepartmentRepository departmentRepository;
    //    private TransactionRepository transactionRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardService.class);

    @Autowired
    public DashboardService(DashboardRepository dashboardRepository, DataRepository dataRepository, DepartmentRepository departmentRepository) {
        this.dashboardRepository = dashboardRepository;
        this.dataRepository = dataRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<DashboardDataDto> getDashboard() {
        List<Departments> departments = departmentRepository.getDepartments();
//        LOGGER.error(departments.toString());
        List<DashboardDataDto> dashboardDepartments = departments.stream().map(departmentDto -> {
            DashboardDataDto dashboard = new DashboardDataDto();
            dashboard.setIdDepartment(departmentDto.getIdDepartment());
            dashboard.setDepartment(departmentDto.getDepartment());
            dashboard.setDataDto(dataRepository.getData(departmentDto.getIdDepartment()));
            return dashboard;
        }).collect(Collectors.toList());
//        LOGGER.debug(dashboardDepartments.toString());
        return dashboardDepartments;
    }

    public List<DashboardDto> getDashboardsByUser(Integer idUser) {
        return dashboardRepository.getDashboardsByUserId(idUser);
    }

//    public DashboardDto addNewDashboard(DashboardDto dashboardDto) {
//    }

}
