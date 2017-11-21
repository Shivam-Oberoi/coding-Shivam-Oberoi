package com.electricity.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VillageConsumptionDTO
{

    private String village_name;

    private Double consumption;


    public VillageConsumptionDTO()
    {

    }


    public void setVillage_name(String village_name)
    {
        this.village_name = village_name;
    }


    public void setConsumption(Double consumption)
    {
        this.consumption = consumption;
    }


    public VillageConsumptionDTO(String village_name, Double consumption)
    {
        this.consumption = consumption;
        this.village_name = village_name;
    }


    public static VillageConsumptionDTOBuilder newBuilder()
    {
        return new VillageConsumptionDTOBuilder();
    }


    public Double getConsumption()
    {
        return consumption;
    }


    public String getVillageName()
    {
        return village_name;
    }

    public static class VillageConsumptionDTOBuilder
    {
        private Double consumption;

        private String village_name;


        public VillageConsumptionDTOBuilder setConsumption(Double consumption)
        {
            this.consumption = consumption;
            return this;
        }


        public VillageConsumptionDTOBuilder setVillageName(String village_name)
        {
            this.village_name = village_name;
            return this;
        }


        public VillageConsumptionDTO createVillageConsumptionDTO()
        {
            return new VillageConsumptionDTO(village_name, consumption);
        }

    }
}
