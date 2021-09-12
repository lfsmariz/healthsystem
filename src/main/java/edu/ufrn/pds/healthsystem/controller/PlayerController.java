package edu.ufrn.pds.healthsystem.controller;

import edu.ufrn.pds.healthsystem.dto.AchievementCompleteDTO;
import edu.ufrn.pds.healthsystem.dto.AchievementsByPlayer;
import edu.ufrn.pds.healthsystem.dto.BoardsByPlayersDTO;
import edu.ufrn.pds.healthsystem.dto.PlayerDTO;
import edu.ufrn.pds.healthsystem.form.AchievementCompleteForm;
import edu.ufrn.pds.healthsystem.form.PlayerForm;
import edu.ufrn.pds.healthsystem.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/create")
    public PlayerDTO createPlayer(@RequestBody PlayerForm playerForm){
        return playerService.create(playerForm);
    }

    @PostMapping("/complete_task")
    public PlayerDTO completeTask(@RequestParam Long id_player, @RequestParam int value){
        return playerService.completeTask(id_player, value);
    }

    @PostMapping("/redeem_achievement")
    public AchievementCompleteDTO redeemAchievement(@RequestBody AchievementCompleteForm form){
        return playerService.redeemAchievement(form);
    }

    @GetMapping("/boards")
    public BoardsByPlayersDTO getBoards(@RequestParam Long id_player){ return playerService.getBoards(id_player); }

    @GetMapping("/my_achievement/{id_player}")
    public AchievementsByPlayer getMyAchievements(@PathVariable Long id_player){ return playerService.getMyAchievements(id_player); }

    @GetMapping("/{id_player}")
    public PlayerDTO getPlayer(@PathVariable Long id_player){ return playerService.getPlayer(id_player); }
}
