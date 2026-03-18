package com.koustav.Websocket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "user_details")
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, unique = true)
    private String userId; // You can set this manually in service if needed (e.g., "UID00001")

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = true, name = "phone_num")
    private String contactNumber;

    @Column(nullable = true)
    private String gender;

    @Column(nullable = true, name = "email")
    private String email;

    @Column(nullable = true)
    private Integer age;

    @Column(nullable = true, name = "date_of_birth")
    private LocalDate dob;

    @Column(nullable = false)
    private String password;
}
