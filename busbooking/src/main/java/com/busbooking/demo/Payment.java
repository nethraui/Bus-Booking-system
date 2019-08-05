package com.busbooking.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "cardholdername")
    public String cardholdername;
    @Column(name = "cardnumber")
    public int cardnumber;
    @Column(name = "month")
    public String month;
    @Column(name = "year")
    public int year;
    @Column(name = "cvv")
    public int cvv;

    @ManyToMany
    private Set<UserLogin> userconnect;

    @ManyToMany
    private Set<BusInfo> buspayment;

    public Set<UserLogin> getUserconnect() {
        return userconnect;
    }

    public void setUserconnect(Set<UserLogin> userconnect) {
        this.userconnect = userconnect;
    }

    public String getCardholdername() {
        return cardholdername;
    }

    public void setCardholdername(String cardholdername) {
        this.cardholdername = cardholdername;
    }

    public int getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(int cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Payment(){

    }
}

