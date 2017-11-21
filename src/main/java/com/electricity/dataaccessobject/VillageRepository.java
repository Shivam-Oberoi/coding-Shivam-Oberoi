package com.electricity.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import com.electricity.domainobject.VillageDO;

public interface VillageRepository extends CrudRepository<VillageDO, Long>
{

}
