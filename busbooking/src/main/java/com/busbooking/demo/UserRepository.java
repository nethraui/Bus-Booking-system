package com.busbooking.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserLogin, Integer> {

    UserLogin findByUserNameAndPassWord(String userName, String passWord);

}
