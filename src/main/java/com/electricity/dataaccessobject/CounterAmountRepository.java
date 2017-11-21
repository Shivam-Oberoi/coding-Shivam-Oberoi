package com.electricity.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import com.electricity.domainobject.CounterAmountDO;

public interface CounterAmountRepository extends CrudRepository<CounterAmountDO, Long>
{

}
