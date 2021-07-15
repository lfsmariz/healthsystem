package edu.ufrn.pds.healthsystem.controller;

import edu.ufrn.pds.healthsystem.dto.PlayerDTO;
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
    public PlayerDTO completeTask(@RequestParam Long id_player){
        return playerService.completeTask(id_player);
    }
}
