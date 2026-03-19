package com.koustav.Websocket.model;

import lombok.*;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Message {

    @Id
    private String id;

    private String roomId;
    private String sender;
    private String content;

    private LocalDateTime timestamp;


    public Message(String roomId,String sender,String content )
    {
        this.roomId=roomId;
        this.sender=sender;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
}
