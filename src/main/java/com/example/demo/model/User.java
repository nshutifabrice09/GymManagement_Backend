package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(unique = true)
    private String membershipId;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String password;
    private String address;
    private int age;
    private int weight;
    @OneToMany(mappedBy = "user")
    private List<Booking> booking;

}
