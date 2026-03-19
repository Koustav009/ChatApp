package com.koustav.Websocket.controller;

import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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

    private final SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/sendmessage/{roomId}") //Every Message from client will be sent to this endpoint

    //@SendTo("/topic/room/{roomId}") //The client will subscribe on this endpoint
    //if i don't want to use @SendTo annotation then we have to use "SimpMessagingTemplate"
    //for subscription of the endpoint 
    public void sendMessage(
        @DestinationVariable String roomId,
        @RequestBody MessageRequest request
        
    )
    {
        System.out.println("The message data="+request);
        Message msg =  serv.sendMessge(roomId,request);


        if (msg!=null) {
            // return ResponseEntity.status(HttpStatus.CREATED).body(msg);
            messagingTemplate.convertAndSend("/topic/room/" + roomId, msg);
            //server will publish every messages to this endpoint(topic) after saving it to database.
            //and client aslo have to SUBSCRIBE on this endpoint to recive every mesasage

            messagingTemplate.convertAndSend("/topic/room/admin", msg);
        }
        
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found Room");
    }
}
