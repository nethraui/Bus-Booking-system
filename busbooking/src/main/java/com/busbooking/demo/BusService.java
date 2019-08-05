package com.busbooking.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

@Service
@Transactional
public class BusService {

    @Autowired
    BusRepository busRepository;

    public List<BusInfo> busInfoList(){
        return (List<BusInfo>) busRepository.findAll();
    }

    public BusInfo addBus(BusInfo busInfo){
        return busRepository.save(busInfo);
    }

    public BusInfo editBus(BusInfo busInfo) {
        return busRepository.save(busInfo);
    }

    public void deleteBus(int busId) {
        busRepository.deleteById(busId);
    }

//    public List<BusInfo> userSearch(){
//        List<BusInfo> resultList = new ArrayList<>();
//
//        busRepository.findAll().forEach(busdetail -> resultList.add(busdetail));
//
//        return resultList;
//    }

    public List<BusInfo> userSearch(String arrival, String destination, Date busDate){
        List<BusInfo> resultList = new ArrayList<>();

        System.out.println(arrival);
        System.out.println(destination);
        System.out.println(busDate);
        busRepository.findAllByArrivalAndDestinationAndBusDate(arrival,destination,busDate)
                .forEach(busdetail -> resultList.add(busdetail));
        System.out.println(resultList);
        return resultList;
    }
}
