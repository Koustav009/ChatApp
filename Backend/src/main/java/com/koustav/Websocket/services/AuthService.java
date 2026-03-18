package com.koustav.Websocket.services;

import com.koustav.Websocket.payload.SignupRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.koustav.Websocket.model.UserInfo;
import com.koustav.Websocket.payload.LoginRequest;
import com.koustav.Websocket.repository.UserRepo;
import java.time.Period;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepo userRepo;

    public Optional<?> loginUser( ){

//        UserInfo user = userRepo.findbyNumber(loginRequest.getNumber());
        return Optional.of("Test mode");
    }

    public Boolean signupUser(UserInfo signupRequest){

        if(userRepo.findbyEmail(signupRequest.getEmail()) != null ){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Email Already Exists");
        }
        if(userRepo.findbyNumber(signupRequest.getContactNumber()) != null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Contact Number Already Exists");
        }

        String latestUid = getLatestUid();

        log.info("lastUid is {}", latestUid);
        signupRequest.setUserId(latestUid);

        if(signupRequest.getDob() != null){
            Integer age = Period.between(signupRequest.getDob(), LocalDate.now()).getYears();
            signupRequest.setAge(age);
        }
        try{
            userRepo.save(signupRequest);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    private String  getLatestUid(){
        Optional<String> lastUid =  userRepo.getLastUid();
        log.info("Latest is {}", lastUid.orElse("null"));

        if(lastUid.isPresent()){
            return getNextUid(lastUid.get());
        }else{
            return "UID0000001";
        }

    }

    public static String getNextUid(String uid) {
        // Extract the prefix (non-digit part) and numeric part
        String prefix = uid.replaceAll("\\d", "");         // "UID"
        String numberPart = uid.replaceAll("\\D", "");      // "0000012"

        int numberLength = numberPart.length();             // to preserve leading zeros
        int number = Integer.parseInt(numberPart);          // convert to integer
        number++;                                           // increment

        // Format back with leading zeros
        String incrementedNumberPart = String.format("%0" + numberLength + "d", number);
        return prefix + incrementedNumberPart;
    }
}