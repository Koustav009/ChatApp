package com.koustav.Websocket.services;

import org.springframework.stereotype.Service;

import com.koustav.Websocket.model.UserInfo;
import com.koustav.Websocket.payload.LoginRequest;
import com.koustav.Websocket.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepo;

    public Optional<?> loginUser(LoginRequest loginRequest){

        UserInfo user = userRepo.findbyNumber(loginRequest.getNumber());

    }
    
}