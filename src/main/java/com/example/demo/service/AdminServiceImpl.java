package com.example.demo.service;
import com.example.demo.repository.AdminRepo;
import com.example.demo.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService{


    private AdminRepo adminRepo;

    public AdminServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return adminRepo.findByUsername(username);
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public void removeByUsername(String username) {
        adminRepo.removeByUsername(username);
    }

    @Override
    public Admin updateAdmin(String username, Admin admin){
        Admin existAdmin = adminRepo.findByUsername(username);
        if(existAdmin !=null){
            existAdmin.setUsername(admin.getUsername());
            existAdmin.setPassword(admin.getPassword());
            return adminRepo.save(existAdmin);
        }
        else return null;
    }
}
