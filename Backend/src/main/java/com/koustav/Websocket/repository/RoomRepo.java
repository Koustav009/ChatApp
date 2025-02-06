package com.koustav.Websocket.repository;

import com.koustav.Websocket.model.Room;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
// import org.springframework.data.mongodb.repository.Query;



public interface RoomRepo extends MongoRepository<Room,String> {

    // @Query("{ 'roomId': ?0 }")
    Room findByRoomId(String roomId);

}
