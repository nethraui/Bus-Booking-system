package com.busbooking.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Login,Integer> {

    Login findByUserNameAndPassWord(String userName, String passWord);


}
