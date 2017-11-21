package com.electricity.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CounterVillageDTO
{
    private Long id;

    private String village_name;


    public CounterVillageDTO()
    {

    }


    public CounterVillageDTO(Long id, String village_name)
    {
        this.id = id;
        this.village_name = village_name;
    }


    public static CounterVillageDTOBuilder newBuilder()
    {
        return new CounterVillageDTOBuilder();
    }


    public Long getId()
    {
        return id;
    }


    public String getVillageName()
    {
        return village_name;
    }

    public static class CounterVillageDTOBuilder
    {
        private Long id;

        private String village_name;


        public CounterVillageDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }


        public CounterVillageDTOBuilder setVillageName(String village_name)
        {
            this.village_name = village_name;
            return this;
        }


        public CounterVillageDTO createCounterVillageDTO()
        {
            return new CounterVillageDTO(id, village_name);
        }

    }

}
