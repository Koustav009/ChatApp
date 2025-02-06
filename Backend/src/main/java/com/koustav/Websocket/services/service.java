package com.koustav.Websocket.services;


import com.koustav.Websocket.model.Message;
import com.koustav.Websocket.model.Room;
import com.koustav.Websocket.payload.MessageRequest;
import com.koustav.Websocket.repository.MessageRepo;
import com.koustav.Websocket.repository.RoomRepo;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class service {

    
    private final RoomRepo roomrepo;

//    public service(RoomRepo roomrepo)
//    {
//        this.roomrepo = roomrepo;
//    }
    
    private final MessageRepo messagerepo;
    // public service(MessageRepo messagerepo) {
    //     this.messagerepo = messagerepo;
    // }

    public boolean checkRoom(String roomId)
    {
        Optional<Room> room = Optional.ofNullable(roomrepo.findByRoomId(roomId));

        return room.isPresent();
    }

    public Room createRoom(String roomId)
    {
        Room room = new Room();
        room.setRoomId(roomId);
        roomrepo.save(room);
        return room;
    }

    public List<Message> getMessages(String roomId, int pageNo , int pageSize)
    {
        Pageable pagable = PageRequest.of(pageNo,pageSize);

        Room room =  roomrepo.findByRoomId(roomId);
        return room.getMessages();

        // return messagerepo.findByRoomId(roomId,pagable).getContent();
    }

    public Room getRoom(String roomId)
    {
        return roomrepo.findByRoomId(roomId);
    }

    public Message sendMessge(String roomId,MessageRequest request)
    {
        Room room = roomrepo.findByRoomId(roomId);
        
        if(!checkRoom(roomId))
        {
            return null;
        }

        Message msg = new Message(roomId,request.getSender(),request.getContent());

        // msg.setRoomId(roomId);
        // msg.setContent(request.getContent());
        // msg.setSender(request.getSender());
        //this is setting system local time , this can be UST
        //you can change it accouding ist
        // msg.setTimestamp(LocalDateTime.now());

        room.getMessages().add(msg);
        roomrepo.save(room);

        return msg;
    }
}
