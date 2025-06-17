package com.koustav.Websocket.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.koustav.Websocket.model.UserInfo;

public interface UserRepo extends MongoRepository<UserInfo,String>{
    
    @Query("{ 'number': ?0 }")
    UserInfo findbyNumber(String number);

    
    @Query("{ 'email': ?0 }")
    UserInfo findbyEmail(String email);
}
