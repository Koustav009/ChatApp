package com.koustav.Websocket.repository;

import com.koustav.Websocket.model.Message;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface MessageRepo extends MongoRepository<Message, String> {

    // Corrected method name
    Page<Message> findByRoomId(String roomId,Pageable pagable);

}