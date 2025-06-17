package com.koustav.Websocket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koustav.Websocket.payload.LoginRequest;
import com.koustav.Websocket.services.AuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    
    private final AuthService authService;

    @GetMapping("/login")
    public ResponseEntity<?> loginUser(
        @RequestBody LoginRequest loginRequest){

            authService.loginUser(loginRequest);
            return ResponseEntity.ok().body(null);

    }

    
}
