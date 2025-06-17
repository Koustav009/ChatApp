package com.koustav.Websocket.payload;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class SignUpRequest {

    private String name;
    private String number;
    private String gender;
    private String email;
    private String password;
    
}
