package com.electricity.datatransferobject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsumptionReportDTO
{

    private List<VillageConsumptionDTO> villages;


    public ConsumptionReportDTO()
    {

    }


    public ConsumptionReportDTO(List<VillageConsumptionDTO> villages)
    {
        this.villages = villages;
    }


    public List<VillageConsumptionDTO> getVillages()
    {
        return villages;
    }


    public static ConsumptionReportDTOBuilder newBuilder()
    {
        return new ConsumptionReportDTOBuilder();
    }

    public static class ConsumptionReportDTOBuilder
    {

        private List<VillageConsumptionDTO> villages;


        public ConsumptionReportDTOBuilder setVillages(List<VillageConsumptionDTO> villages)
        {
            this.villages = villages;
            return this;
        }


        public ConsumptionReportDTO createConsumptionReportDTO()
        {
            return new ConsumptionReportDTO(villages);
        }

    }
}
