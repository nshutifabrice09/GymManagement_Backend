package com.example.demo.controller;


import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/admin")
    public Admin save(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }
    @GetMapping("/admins")
    public List<Admin> adminList(){
     return adminService.getAllAdmins();
    }
    @GetMapping("/admin/{username}")
    public Admin findAdminByUsername(@PathVariable("username") String username){
        return adminService.getAdminByUsername(username);
    }
    @DeleteMapping("/admin/{username}")
    public void removeByUsername(@PathVariable("username") String username){
        adminService.removeByUsername(username);
    }

    @PutMapping("/admin/{username}")
    public Admin updateAdmin(@PathVariable("username") String username, @RequestBody Admin admin){
        return adminService.updateAdmin(username, admin);
    }


}
