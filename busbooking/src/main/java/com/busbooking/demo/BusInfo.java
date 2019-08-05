package com.busbooking.demo;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "buses")
public class BusInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String busName;
    private String busInfo;
    private Time busTime;
    private Date busDate;
    private String destination;
    private String arrival;

    public BusInfo() {
    }

//    public BusInfo(String busName, String busInfo, Time busTime) {
//        this.busName = busName;
//        this.busInfo = busInfo;
//        this.busTime = busTime;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusInfo() {
        return busInfo;
    }

    public void setBusInfo(String busInfo) {
        this.busInfo = busInfo;
    }

    public Time getBusTime() {
        return busTime;
    }

    public void setBusTime(Time busTime) {
        this.busTime = busTime;
    }

    public Date getBusDate() {
        return busDate;
    }

    public void setBusDate(Date busDate) {
        this.busDate = busDate;
    }
}
