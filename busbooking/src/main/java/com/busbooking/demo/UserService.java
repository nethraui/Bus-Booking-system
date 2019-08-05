package com.busbooking.demo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
//
//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserLogin userLogin(UserLogin userLogin){

        //System.out.println(userList().equals(userName));
        System.out.println(userRepository.findByUserNameAndPassWord(userLogin.getUserName(),userLogin.getPassWord()));
        System.out.println(userLogin.getUserName());
        System.out.println(userLogin.getPassWord());
        return userRepository.findByUserNameAndPassWord(userLogin.getUserName(),userLogin.getPassWord());
    }

    public void userSignup(UserLogin user){

        //user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
        user.setActive(0);
        userRepository.save(user);
    }

    public List<UserLogin> userList(){
        return (List<UserLogin>) userRepository.findAll();
    }




}
