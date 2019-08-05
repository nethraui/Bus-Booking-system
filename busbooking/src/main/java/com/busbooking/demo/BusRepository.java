package com.busbooking.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BusRepository extends CrudRepository<BusInfo, Integer> {
    //void deleteByBusName(String busName);

    List<BusInfo> findAllByArrivalAndDestinationAndBusDate(String arrival, String destination, Date busDate);
}
