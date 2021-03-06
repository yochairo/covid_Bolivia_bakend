package com.example.demo.service;

import com.example.demo.dao.DataRepository;
import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dao.MunicipalityRepository;
import com.example.demo.dao.LocationRepository;
import com.example.demo.domain.Data;
import com.example.demo.domain.Transaction;
import com.example.demo.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    private DataRepository dataRepository;
    private DepartmentRepository departmentRepository;
    private LocationRepository locationRepository;
    private MunicipalityRepository municipalityRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DataService.class);

    @Autowired
    public DataService(DataRepository dataRepository, DepartmentRepository departmentRepository, LocationRepository locationRepository, MunicipalityRepository municipalityRepository) {
        this.dataRepository = dataRepository;
        this.departmentRepository = departmentRepository;
        this.locationRepository = locationRepository;
        this.municipalityRepository = municipalityRepository;
    }

    public DailyDataDto pushSingleData(DailyDataDto dailyDataDto, Transaction transaction) {
        Integer idLocation = locationRepository.getLocationByDepartment(dailyDataDto.getDepartment(), dailyDataDto.getMunicipality());

        LOGGER.warn("EL RESULTADO");

        LOGGER.warn(idLocation != null ? idLocation.toString() : null);
        LOGGER.warn("resultado: " + dailyDataDto.getConfirmed());
        if (idLocation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find location");
        }
        if (dailyDataDto.getConfirmed() != null) {
            Data confirmed = new Data(null, dailyDataDto.getConfirmed(), dailyDataDto.getInDate(), idLocation, 1, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            LOGGER.info("DATOS REGISTRADOS");
            dataRepository.addSingleData(confirmed);

        }
        if (dailyDataDto.getDeaths() != null) {
            Data deaths = new Data(null, dailyDataDto.getDeaths(), dailyDataDto.getInDate(), idLocation, 2, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            LOGGER.info("DATOS REGISTRADOS");
            dataRepository.addSingleData(deaths);
        }
        if (dailyDataDto.getRecovered() != null) {
            Data recovered = new Data(null, dailyDataDto.getRecovered(), dailyDataDto.getInDate(), idLocation, 3, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            LOGGER.info("DATOS REGISTRADOS");
            dataRepository.addSingleData(recovered);

        }
        if (dailyDataDto.getFirstDose() != null) {
            Data firstDose = new Data(null, dailyDataDto.getFirstDose(), dailyDataDto.getInDate(), idLocation, 4, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            LOGGER.info("DATOS REGISTRADOS");
            dataRepository.addSingleData(firstDose);

        }
        if (dailyDataDto.getSecondDose() != null) {
            Data secondDose = new Data(null, dailyDataDto.getSecondDose(), dailyDataDto.getInDate(), idLocation, 5, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            LOGGER.info("DATOS REGISTRADOS");
            dataRepository.addSingleData(secondDose);
        }
        LOGGER.warn(idLocation.toString());
        return dailyDataDto;
    }

    public DataUpdateDto dataid(DataUpdateDto dataUpdateDto, Transaction transaction) {

        Integer idLocation = locationRepository.getLocationIds(dataUpdateDto.getIddepartment(), dataUpdateDto.getIdmunicipality(), dataUpdateDto.getIdcountry());

        LOGGER.warn(idLocation != null ? idLocation.toString() : null);
        LOGGER.warn("el dato es: " + dataUpdateDto.getDataType());
        if (idLocation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find location");
        }
        if (dataUpdateDto.getDataType() == 1) {
            List<DataDto> listaData = dataRepository.verifyExistenceOfData(dataUpdateDto.getInDate(), dataUpdateDto.getDataType(), idLocation);
            if (listaData.isEmpty()) {
                Data confirmed = new Data(null, dataUpdateDto.getData(), dataUpdateDto.getInDate(), idLocation, dataUpdateDto.getDataType(), 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
                dataRepository.addSingleData(confirmed);
            } else {
                LOGGER.info("ERROR");
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "the data already exists");
            }

        } else if (dataUpdateDto.getDataType() == 2) {
            List<DataDto> listaData = dataRepository.verifyExistenceOfData(dataUpdateDto.getInDate(), dataUpdateDto.getDataType(), idLocation);
            if (listaData.isEmpty()) {
                Data Deaths = new Data(null, dataUpdateDto.getData(), dataUpdateDto.getInDate(), idLocation, dataUpdateDto.getDataType(), 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
                dataRepository.addSingleData(Deaths);
            } else {
                LOGGER.info("ERROR");
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "the data already exists");
            }

        } else if (dataUpdateDto.getDataType() == 3) {
            List<DataDto> listaData = dataRepository.verifyExistenceOfData(dataUpdateDto.getInDate(), dataUpdateDto.getDataType(), idLocation);
            if (listaData.isEmpty()) {
                Data Recovered = new Data(null, dataUpdateDto.getData(), dataUpdateDto.getInDate(), idLocation, dataUpdateDto.getDataType(), 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
                dataRepository.addSingleData(Recovered);
            } else {
                LOGGER.info("ERROR");
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "the data already exists");
            }
        } else if (dataUpdateDto.getDataType() == 4) {
            List<DataDto> listaData = dataRepository.verifyExistenceOfData(dataUpdateDto.getInDate(), dataUpdateDto.getDataType(), idLocation);
            if (listaData.isEmpty()) {
                Data firstDose = new Data(null, dataUpdateDto.getData(), dataUpdateDto.getInDate(), idLocation, dataUpdateDto.getDataType(), 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
                dataRepository.addSingleData(firstDose);
            } else {
                LOGGER.info("ERROR");
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "the data already exists");
            }
        } else if (dataUpdateDto.getDataType() == 5) {
            List<DataDto> listaData = dataRepository.verifyExistenceOfData(dataUpdateDto.getInDate(), dataUpdateDto.getDataType(), idLocation);
            if (listaData.isEmpty()) {
                Data secondDose = new Data(null, dataUpdateDto.getData(), dataUpdateDto.getInDate(), idLocation, dataUpdateDto.getDataType(), 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
                dataRepository.addSingleData(secondDose);
            } else {
                LOGGER.info("ERROR");
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "the data already exists");
            }
        }
        LOGGER.warn(idLocation.toString());
        return dataUpdateDto;
    }


    public List<DataSimpleDto> lastDataByLocation(Integer idLocation) {
        return dataRepository.lastDataByLocation(idLocation);
    }

    public List<DataSimpleDto> listSpecificDataByIdDepartment(Integer idDatatype, Integer idDepartment) {
        return departmentRepository.listSpecificDataByIdDepartment(idDatatype, idDepartment);
    }

    public List<DataDto> getDataByCountryId(String idCountry) {
        return locationRepository.getGeneralDataByCountry(idCountry);
    }

    public List<DataDto> getByCountryId(String idCountry) {
        return locationRepository.getDataByCountry(idCountry);
    }
}
