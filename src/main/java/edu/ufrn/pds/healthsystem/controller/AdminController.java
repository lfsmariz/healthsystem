package edu.ufrn.pds.healthsystem.controller;

import edu.ufrn.pds.healthsystem.dto.AchievementDTO;
import edu.ufrn.pds.healthsystem.dto.BoardDTO;
import edu.ufrn.pds.healthsystem.entity.Board;
import edu.ufrn.pds.healthsystem.form.AchievementForm;
import edu.ufrn.pds.healthsystem.form.BoardForm;
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

    @PostMapping("/createboard")
    public BoardDTO createBoard(@RequestBody BoardForm boardForm){
        return adminService.createBoard(boardForm);
    }

    @PostMapping("/createachievement")
    public AchievementDTO createAchievement(@RequestBody AchievementForm achievementForm) {
        return adminService.createAchievement(achievementForm);
    }
}
