package com.electricity.domainobject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "counter")
public class CounterDO
{

    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VILLAGE_ID")
    private VillageDO village;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public VillageDO getVillage()
    {
        return this.village;
    }


    public void setVillage(VillageDO village)
    {
        this.village = village;
    }
}
