package com.koustav.Websocket.controller;

import com.koustav.Websocket.model.Message;
import com.koustav.Websocket.model.Room;
import com.koustav.Websocket.services.service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@CrossOrigin("*")
public class RoomController {

    private final service serv;
    public RoomController(service serv)
    {
        this.serv=serv;
    }


    //create room

    @PostMapping("/createroom/{roomId}")
    public ResponseEntity<?> createRoom(@PathVariable String roomId)
    {

        //check if the room is available or not

        if(serv.checkRoom(roomId))
        {
            
            return ResponseEntity.badRequest().body("Name already Exist");
        }

        Room room = serv.createRoom(roomId);

        return ResponseEntity.status(HttpStatus.CREATED).body(room);

    }

    //get room: joining a room

    @GetMapping("/joinroom/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId)
    {
        if(!serv.checkRoom(roomId))
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Room found");
        }

        Room room  = serv.getRoom(roomId);

        return ResponseEntity.status(HttpStatus.OK).body(room);

    }

    //get messages of room
    @GetMapping("/getmessages/{roomId}")
    public ResponseEntity<?> getMessages(
            @PathVariable String roomId,
            @RequestParam(value = "page", defaultValue = "0")  int pageNO,
            @RequestParam(value = "size", defaultValue = "20") int pageSize)
    {
        System.out.println("Checking the Room.........before");
        if(!serv.checkRoom(roomId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Room found");
        }

        List<Message> msg = serv.getMessages(roomId,pageNO,pageSize);

        return ResponseEntity.status(HttpStatus.OK).body(msg);

    }






}
