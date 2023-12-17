package com.example.demo.service;

import com.example.demo.model.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmins();
    Admin getAdminByUsername(String username);
    Admin saveAdmin(Admin admin);

    Admin updateAdmin(String username, Admin admin);

    void removeByUsername(String username);
}
