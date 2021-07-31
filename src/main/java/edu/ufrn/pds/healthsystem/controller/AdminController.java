package edu.ufrn.pds.healthsystem.controller;

import edu.ufrn.pds.healthsystem.dto.*;
import edu.ufrn.pds.healthsystem.form.*;
import org.springframework.beans.factory.annotation.Autowired;
import edu.ufrn.pds.healthsystem.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

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

    @PostMapping("/registerplayer")
    public RegisterDTO registerPlayer(@RequestBody RegisterPlayerForm registerPlayerForm) {
        return adminService.registerPlayer(registerPlayerForm);
    }

    @GetMapping("/get_achievements")
    public AchievementsByBoardDTO getAchievementsActiveUser(
            @RequestParam Long id_board,
            @RequestParam Long id_user
    ){
        return  adminService.getAchievementsActiveUser(id_board, id_user);
    }

    @GetMapping("/boards/{idAdmin}")
    public AdminBoardsDTO getBoards(@PathVariable Long idAdmin){
        return  adminService.getBoards(idAdmin);
    }

    @GetMapping("/board_players/{idBoard}")
    public BoardPlayersDTO getBoardPlayers(@PathVariable Long idBoard){
        return  adminService.getBoardPlayers(idBoard);
    }

    @GetMapping("/{idAdmin}")
    public AdminDTO getAdmin(@PathVariable Long idAdmin){ return adminService.getAdmin(idAdmin); }

    @GetMapping("/get_achievements/{idBoard}")
    public AchievementsByBoardDTO getAchievementsBoard(
            @PathVariable Long idBoard
    ){
        return  adminService.getAchievementsActiveUser(idBoard);
    }
}
