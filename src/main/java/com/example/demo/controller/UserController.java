package com.example.demo.controller;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/user")
    public User save(@RequestBody User user){
        return userService.saveUser(user);

    }

    @GetMapping("/users")
    public List<User> userList(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{membershipId}")
    public User findUserByMembershipId(@PathVariable("membershipId") String membershipId){
        return userService.getUserByMembershipId(membershipId);
    }

    @DeleteMapping("/user/user/{membershipId}")
    public void removeByMembershipId(@PathVariable("membershipId")String membershipId){
        userService.removeByMembershipId(membershipId);
    }

    @PutMapping("/users/users/{membershipId}")
    public User updateUser(@PathVariable("membershipId") String membershipId, @RequestBody User user){
        return userService.updateUser(membershipId, user);
    }
}
