package com.example.demo.exception;

public class UserNotFoundException  extends RuntimeException{

    public UserNotFoundException (String membershipID){
        super("Could not find the user membershipID "+membershipID);
    }
}
