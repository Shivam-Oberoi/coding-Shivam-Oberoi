package com.electricity.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.electricity.DummyDataTest;
import com.electricity.datatransferobject.CounterAmountDTO;
import com.electricity.domainobject.CounterAmountDO;
import com.electricity.service.CounterService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CounterControllerTest extends DummyDataTest
{
    private static final ObjectMapper mapper = new ObjectMapper();

    private MockMvc mvc;

    @Mock
    private CounterService counterService;

    @InjectMocks
    private CounterController counterController;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(CounterController.class);
    }


    @Before
    public void init()
    {
        mvc = MockMvcBuilders.standaloneSetup(counterController).dispatchOptions(true).build();
    }


    @Test
    public void addConsumptionTest() throws Exception
    {
        CounterAmountDTO counterAmountDTO = getCounterAmountDTO();
        CounterAmountDO counterAmountDO = getCounterAmountDO();
        String jsonInString = mapper.writeValueAsString(counterAmountDTO);
        doReturn(counterAmountDO).when(counterService).addConsumption(any(CounterAmountDO.class));
        counterController.addConsumption(counterAmountDTO);
        MvcResult result = mvc
            .perform(post("/v1/counter/callback").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonInString))
            .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertTrue(responseBody.contains("200.0"));
    }


    @Test
    public void getVillageTest() throws Exception
    {
        
        doReturn("gurgaon").when(counterService).getVillage(1L);
        counterController.getVillage(1L);
        MvcResult result = mvc
            .perform(get("/v1/counter?id=1").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertTrue(responseBody.contains("gurgaon"));
    }


    @Test
    public void getConsumptionReportTest() throws Exception
    {
        List<Object[]> consumptionReport = getConsumptionReport();
        doReturn(consumptionReport).when(counterService).getConsumptionReport("24h");
        counterController.getConsumptionReport("24h");
        MvcResult result = mvc
            .perform(get("/v1/counter/consumption_report?duration=24h").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertTrue(responseBody.contains("200.0"));
    }
}
