package com.busbooking.demo;

public interface ContactService {

    void send(String fromAddress, String toAddress,String subject, String content) throws Exception;
}
