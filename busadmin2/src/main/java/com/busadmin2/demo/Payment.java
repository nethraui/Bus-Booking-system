package com.busadmin2.demo;

public class Payment {

    String cardholdername;

    int cardnumber;

    String month;

    int year;

    int cvv;
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }



    public Payment(String cardholdername, int cardnumber, String month, int year, int cvv) {
        this.cardholdername = cardholdername;
        this.cardnumber = cardnumber;
        this.month = month;
        this.year = year;
        this.cvv = cvv;
    }

    public Payment(){

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


    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getCvv() {
        return cvv;
    }
}
