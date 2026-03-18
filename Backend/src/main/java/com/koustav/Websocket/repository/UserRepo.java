package com.koustav.Websocket.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.koustav.Websocket.model.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<UserInfo,Long> {



    Optional<UserInfo> findbyNumber(String number);

    
    Optional<UserInfo> findbyEmail(String email);

    @Query(value = "SELECT user_id FROM user_details ORDER BY CAST(SUBSTRING(user_id, 4) AS UNSIGNED) DESC LIMIT 1", nativeQuery = true)
    Optional<String> getLastUid();


}
