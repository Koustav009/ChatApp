package com.koustav.Websocket.controller;

import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.koustav.Websocket.model.Message;
import com.koustav.Websocket.payload.MessageRequest;
import com.koustav.Websocket.services.service;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@CrossOrigin("*")
public class ChatController {

    private final service serv;

    @MessageMapping("/sendmessage/{roomId}") //Every Message from client will be sent to this endpoint
    @SendTo("/topic/room/{roomId}") //The client will subscribe on this endpoint
    public ResponseEntity<?> sendMessage(
        @DestinationVariable String roomId,
        @RequestBody MessageRequest request
        
    )
    {
        Message msg =  serv.sendMessge(roomId,request);

        if (msg==null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found Room");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(msg);
    }
}
