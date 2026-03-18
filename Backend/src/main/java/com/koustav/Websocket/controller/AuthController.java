package com.koustav.Websocket.controller;

import com.koustav.Websocket.model.UserInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koustav.Websocket.services.AuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;


    @GetMapping("/login")
    public ResponseEntity<?> loginUser(
    ){


            return ResponseEntity.ok().body(authService.loginUser().get());

    }
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(
        @RequestBody UserInfo signupRequest){

            if (authService.signupUser(signupRequest)){
            return ResponseEntity.status(HttpStatus.CREATED).body("Account Created Successfully");
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Credentials");
            }

    }

    
}
