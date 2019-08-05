package com.busbooking.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
    /* public Payment pay(Payment payment){
         return repository.save(payment);
     }*/
    public  void set(Payment payment){
        Payment payment1=new Payment();
        payment1.setCardholdername(payment.getCardholdername());
        payment1.setCardnumber(payment.getCardnumber());
        payment1.setCvv(payment.getCvv());
        payment1.setYear(payment.getYear());
        payment1.setMonth(payment.getMonth());
        paymentRepository.save(payment1);
    }

    public List<Payment> getpaymentdetails() {
        List<Payment> paymentList = new ArrayList<>();
        paymentRepository.findAll().forEach(e -> paymentList.add(e));
        return paymentList;
    }
}
