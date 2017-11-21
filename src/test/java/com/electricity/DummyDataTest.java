package com.electricity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.electricity.datatransferobject.ConsumptionReportDTO;
import com.electricity.datatransferobject.CounterAmountDTO;
import com.electricity.datatransferobject.CounterVillageDTO;
import com.electricity.datatransferobject.VillageConsumptionDTO;
import com.electricity.domainobject.CounterAmountDO;
import com.electricity.domainobject.CounterDO;
import com.electricity.domainobject.VillageDO;

@RunWith(MockitoJUnitRunner.class)
public abstract class DummyDataTest
{

    public CounterDO getCounter()
    {
        CounterDO counterDO = new CounterDO();
        counterDO.setId(1L);
        counterDO.setVillage(getVillage());
        return counterDO;
    }


    public VillageDO getVillage()
    {
        VillageDO villageDO = new VillageDO();
        villageDO.setId(1L);
        villageDO.setName("New Delhi");
        return villageDO;
    }


    public CounterAmountDO getCounterAmountDO()
    {
        CounterAmountDO counterAmountDO = new CounterAmountDO();
        counterAmountDO.setId(1L);
        counterAmountDO.setCounterId(1L);
        counterAmountDO.setAmount(200.0);
        counterAmountDO.setDateCreated(LocalDateTime.now());
        return counterAmountDO;
    }


    public CounterAmountDTO getCounterAmountDTO()
    {
        CounterAmountDTO counterAmountDTO = CounterAmountDTO.newBuilder().setAmount(200.0).setCounter_id(1L).createCounterAmountDTO();
        return counterAmountDTO;
    }


    public CounterVillageDTO getCounterVillageDTO()
    {
        CounterVillageDTO counterVillageDTO = CounterVillageDTO.newBuilder().setId(1L).setVillageName("gurgaon").createCounterVillageDTO();
        return counterVillageDTO;
    }


    public List<Object[]> getConsumptionReport()
    {
        Object [] object1 = {"gurgaon", 200.0};
        Object [] object2 = {"delhi", 300.0};
        List<Object[]> list = new ArrayList<>();
        list.add(object1);
        list.add(object2);
        return list;
    }
}
