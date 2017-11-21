package com.electricity.dataaccessobject;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.electricity.domainobject.CounterDO;

public interface CounterRepository extends CrudRepository<CounterDO, Long>
{
    @Query("SELECT V.name as Village, SUM(CA.amount) as Consumption from VillageDO V, CounterDO C, CounterAmountDO CA where CA.dateCreated between ?1 and ?2 and CA.counterId = C.id and C.village=V.id group by V.id")
    List<Object[]> findVillagesForReport(@Param("reportRange") LocalDateTime reportRange,
        @Param("currentTime") LocalDateTime currentTime);


    @Query("SELECT V.name as villageName from VillageDO V, CounterDO C where C.village = V.id and C.id = :id")
    Object findVillage(@Param("id") Long id);

}
