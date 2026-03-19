package com.koustav.Websocket.payload;

// import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class MessageRequest {

    private String content;
    private String sender;
    private String roomId;
    
    
}
