package com.electricity.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.electricity.DummyDataTest;
import com.electricity.dataaccessobject.CounterRepository;
import com.electricity.exception.CounterNotFoundException;
import com.electricity.exception.InvalidFormatException;

public class CounterServiceTest extends DummyDataTest
{

    @Mock
    private CounterRepository counterRepository;

    @InjectMocks
    CounterServiceImpl counterService;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(CounterServiceImpl.class);
    }


    @Test
    public void findVillageByCounterIdTest()
    {
        String villageName = "gurgaon";
        when(counterRepository.exists(any(Long.class))).thenReturn(true);
        when(counterRepository.findVillage(any(Long.class))).thenReturn(villageName);
        counterService.getVillage(any(Long.class));
        verify(counterRepository, times(1)).findVillage(any(Long.class));
    }


    @Test(expected = CounterNotFoundException.class)
    public void findVillageByWrongCounterIdTest()
    {
        when(counterRepository.exists(any(Long.class))).thenReturn(false);
        counterService.getVillage(any(Long.class));
    }


    @Test
    public void findConsumptionReportTest()
    {
        when(counterRepository.findVillagesForReport(any(LocalDateTime.class), any(LocalDateTime.class))).thenReturn(getConsumptionReport());
        counterService.getConsumptionReport("24h");
        verify(counterRepository, times(1)).findVillagesForReport(any(LocalDateTime.class), any(LocalDateTime.class));
    }


    @Test(expected = InvalidFormatException.class)
    public void findInvalidFormatConsumptionReportTest()
    {
        counterService.getConsumptionReport("24hours");
    }
}
