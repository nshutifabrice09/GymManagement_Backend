package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.TrainerRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserByMembershipId(String membershipId) {
        return userRepo.findByMembershipId(membershipId);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);

    }

    @Override
    public User updateUser(String membershipId, User user) {
        User existUser = userRepo.findByMembershipId(membershipId);
        if(existUser != null){
            existUser.setMembershipId(user.getMembershipId());
            existUser.setFirst_name(user.getFirst_name());
            existUser.setLast_name(user.getLast_name());
            existUser.setEmail(user.getEmail());
            existUser.setPhone_number(user.getPhone_number());
            existUser.setPassword(user.getPassword());
            existUser.setAddress(user.getAddress());
            existUser.setAge(user.getAge());
            existUser.setWeight(user.getWeight());
        }return null;
    }

    @Override
    public void removeByMembershipId(String membershipId) {
        userRepo.removeByMembershipId(membershipId);
    }
}
