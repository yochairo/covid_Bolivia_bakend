package com.example.demo.controller;

import com.example.demo.domain.Transaction;
import com.example.demo.dto.DailyDataDto;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.*;
import com.example.demo.service.DataService;
import com.example.demo.service.TransactionService;
import com.example.demo.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/data")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DataController {
    private final DataService dataService;
    private final TransactionService transactionService;

    @Autowired
    public DataController(DataService dataService, TransactionService transactionService) {
        this.dataService = dataService;
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/new/single", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public DailyDataDto pushSingleData(@RequestBody DailyDataDto dailyDataDto, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionService.createTransaction(transaction);
        return dataService.pushSingleData(dailyDataDto, transaction);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public DataUpdateDto pushDatabyids(@RequestBody DataUpdateDto dataUpdateDto, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionService.createTransaction(transaction);
        return dataService.dataid(dataUpdateDto, transaction);
    }

    @RequestMapping(value = "/last/day/{idLocation}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> mostRecentDateOfCovidData(@PathVariable Integer idLocation) {
        return dataService.lastDataByLocation(idLocation);
    }

    @RequestMapping(value = "/general/{idCountry}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataDto> getGeneralDataCountry(@PathVariable String idCountry) {
        return dataService.getDataByCountryId(idCountry);
    }

    @RequestMapping(value = "/general/list/{idCountry}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataDto> getDataCountry(@PathVariable String idCountry) {
        return dataService.getByCountryId(idCountry);
    }
}
