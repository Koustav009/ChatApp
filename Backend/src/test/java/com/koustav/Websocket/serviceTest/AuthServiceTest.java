package com.koustav.Websocket.serviceTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.koustav.Websocket.services.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//@Testable
@Slf4j
public class AuthServiceTest {

    private final AuthService authService;

    public AuthServiceTest(AuthService authService) {
        this.authService = authService;
    }

//    @Test
    void SignupTEst(){

        LocalDate date = LocalDate.of(2003, 8, 24);
        Map<String, Object> map = new HashMap<>();
        map.put("name","Koustav test");
        map.put("contactNumber","1234567890");
        map.put("password","test123");
        map.put("email","test@test");
        map.put("dob",date);
        map.put("gender","M");
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(map);
        }catch (Exception e){
            e.printStackTrace();
        }

//        authService.signupUser(json);/

    }
}
