package com.electricity.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CounterAmountDTO
{
    private Long counter_id;

    private Double amount;


    public CounterAmountDTO()
    {

    }


    public CounterAmountDTO(Long counter_id, Double amount)
    {
        this.counter_id = counter_id;
        this.amount = amount;
    }


    public static CounterDTOBuilder newBuilder()
    {
        return new CounterDTOBuilder();
    }


    public Long getCounter_id()
    {
        return counter_id;
    }


    public Double getAmount()
    {
        return amount;
    }

    public static class CounterDTOBuilder
    {
        private Long counter_id;

        private Double amount;


        public CounterDTOBuilder setCounter_id(Long counter_id)
        {
            this.counter_id = counter_id;
            return this;
        }


        public CounterDTOBuilder setAmount(Double amount)
        {
            this.amount = amount;
            return this;
        }


        public CounterAmountDTO createCounterAmountDTO()
        {
            return new CounterAmountDTO(counter_id, amount);
        }

    }
}
