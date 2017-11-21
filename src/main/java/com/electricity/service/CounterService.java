package com.electricity.service;

import java.util.List;

import com.electricity.domainobject.CounterAmountDO;

public interface CounterService
{
    CounterAmountDO addConsumption(CounterAmountDO counterAmountDO);

    String getVillage(long id);

    List<Object[]> getConsumptionReport(String duration);
}
