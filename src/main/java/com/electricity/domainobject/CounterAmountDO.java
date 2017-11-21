package com.electricity.domainobject;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "counterAmount")
public class CounterAmountDO
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateCreated = LocalDateTime.now();

    @Column
    private Long counterId;

    @Column
    private Double amount;


    public void setId(Long id)
    {
        this.id = id;
    }


    public Long getId()
    {
        return id;
    }


    public LocalDateTime getDateCreated()
    {
        return dateCreated;
    }


    public void setDateCreated(LocalDateTime dateCreated)
    {
        this.dateCreated = dateCreated;
    }


    public Double getAmount()
    {
        return amount;
    }


    public void setAmount(Double amount)
    {
        this.amount = amount;
    }


    public Long getCounterId()
    {
        return counterId;
    }


    public void setCounterId(Long counterId)
    {
        this.counterId = counterId;
    }
}
