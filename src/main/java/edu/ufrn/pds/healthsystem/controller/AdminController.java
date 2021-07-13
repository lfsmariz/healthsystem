package edu.ufrn.pds.healthsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import edu.ufrn.pds.healthsystem.dto.AdminDTO;
import edu.ufrn.pds.healthsystem.form.AdminForm;
import edu.ufrn.pds.healthsystem.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController (AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public AdminDTO createAdmin (@RequestBody AdminForm adminForm){
        return adminService.create(adminForm);
    }
}
