package com.koustav.Websocket.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "User")
public class UserInfo {
    
    @Id
    private String id;
    private Integer userId;
    private String name;
    private String number;
    private String gender;
    private String email;
    private String password;
    
}
