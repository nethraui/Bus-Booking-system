package com.busbooking.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public Login loginDetails(Login login){
        System.out.println(login.getUserName());
        System.out.println(login.getPassWord());
        login.setActive(1);
        System.out.println(loginRepository.findByUserNameAndPassWord(login.getUserName(),login.getPassWord()));
        return loginRepository.findByUserNameAndPassWord(login.getUserName(),login.getPassWord());
    }

    public void signup(Login login){
        login.setActive(0);
        loginRepository.save(login);
    }

    public List<Login> userList(){
        return (List<Login>) loginRepository.findAll();
    }
}
