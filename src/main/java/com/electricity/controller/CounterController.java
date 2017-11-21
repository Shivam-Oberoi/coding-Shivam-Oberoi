package com.electricity.controller;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.electricity.datatransferobject.ConsumptionReportDTO;
import com.electricity.datatransferobject.CounterAmountDTO;
import com.electricity.datatransferobject.CounterVillageDTO;
import com.electricity.domainobject.CounterAmountDO;
import com.electricity.mapper.CounterMapper;
import com.electricity.service.CounterService;

/**
 * Controller for all counter related functionalities.
 * 
 * <p/>
 */
@RestController
@RequestMapping("/counter")
public class CounterController
{
    private final CounterService counterService;


    @Autowired
    public CounterController(final CounterService counterService)
    {
        this.counterService = counterService;
    }


    @PostMapping("/callback")
    @ResponseStatus(HttpStatus.CREATED)
    public CounterAmountDTO addConsumption(@Valid @RequestBody CounterAmountDTO counterAmountDTO)
    {
        CounterAmountDO counterAmountDO = CounterMapper.makeCounterDO(counterAmountDTO);
        return CounterMapper.makeCounterAmountDTO(counterService.addConsumption(counterAmountDO));
    }


    @GetMapping
    public CounterVillageDTO getVillage(@QueryParam("id") long id) throws EntityNotFoundException
    {
        return CounterMapper.makeCounterVillageDTO(counterService.getVillage(id), id);
    }


    @GetMapping("consumption_report")
    public ConsumptionReportDTO getConsumptionReport(@QueryParam("duration") String duration)
    {
        return CounterMapper.makeConsumptionReportDTO(counterService.getConsumptionReport(duration));
    }
}
