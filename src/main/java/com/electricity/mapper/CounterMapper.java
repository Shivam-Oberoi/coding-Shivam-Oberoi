package com.electricity.mapper;

import java.util.ArrayList;
import java.util.List;

import com.electricity.datatransferobject.ConsumptionReportDTO;
import com.electricity.datatransferobject.CounterAmountDTO;
import com.electricity.datatransferobject.CounterVillageDTO;
import com.electricity.datatransferobject.VillageConsumptionDTO;
import com.electricity.domainobject.CounterAmountDO;

public class CounterMapper
{

    public static CounterAmountDTO makeCounterAmountDTO(CounterAmountDO counterAmountDO)
    {

        CounterAmountDTO.CounterDTOBuilder counterAmountDTOBuilder = CounterAmountDTO.newBuilder().setCounter_id(counterAmountDO.getCounterId())
            .setAmount(counterAmountDO.getAmount());
        return counterAmountDTOBuilder.createCounterAmountDTO();
    }


    public static CounterAmountDO makeCounterDO(CounterAmountDTO counterAmountDTO)
    {
        CounterAmountDO counterAmountDO = new CounterAmountDO();
        counterAmountDO.setCounterId(counterAmountDTO.getCounter_id());
        counterAmountDO.setAmount(counterAmountDTO.getAmount());
        return counterAmountDO;
    }


    public static CounterVillageDTO makeCounterVillageDTO(String villageName, Long id)
    {

        CounterVillageDTO.CounterVillageDTOBuilder counterVillageDTOBuilder = CounterVillageDTO.newBuilder().setId(id).setVillageName(villageName);
        return counterVillageDTOBuilder.createCounterVillageDTO();
    }


    public static ConsumptionReportDTO makeConsumptionReportDTO(List<Object[]> consumptionReport)
    {
        List<VillageConsumptionDTO> reportDTO = new ArrayList<>();
        for (Object[] report : consumptionReport)
        {
            String villageName = (String) report[0];
            Double consumption = (Double) report[1];
            reportDTO.add(VillageConsumptionDTO.newBuilder().setVillageName(villageName).setConsumption(consumption).createVillageConsumptionDTO());
        }
        ConsumptionReportDTO.ConsumptionReportDTOBuilder consumptionReportDTOBuilder = ConsumptionReportDTO.newBuilder().setVillages(reportDTO);
        return consumptionReportDTOBuilder.createConsumptionReportDTO();
    }
}
