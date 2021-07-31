package edu.ufrn.pds.healthsystem.service;

import edu.ufrn.pds.healthsystem.dto.*;
import edu.ufrn.pds.healthsystem.entity.Achievement;
import edu.ufrn.pds.healthsystem.entity.Player;
import edu.ufrn.pds.healthsystem.form.AchievementCompleteForm;
import edu.ufrn.pds.healthsystem.form.PlayerForm;
import edu.ufrn.pds.healthsystem.repository.AchievementRepository;
import edu.ufrn.pds.healthsystem.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final AchievementRepository achievementRepository;

    @Autowired
    PlayerService(PlayerRepository playerRepository, AchievementRepository achievementRepository){
        this.playerRepository = playerRepository;
        this.achievementRepository = achievementRepository;
    }

    public PlayerDTO create(PlayerForm playerForm){
        Player player = new Player(playerForm.getName());
        Player p = playerRepository.save(player);

        return new PlayerDTO(p);
    }

    public PlayerDTO completeTask(Long idPlayer){
        Player player = playerRepository.findById(idPlayer).orElseThrow(RuntimeException::new);
        player.setPoints( player.getPoints() + 1);

        Player p = playerRepository.save(player);

        return new PlayerDTO(p);
    }

    public BoardsByPlayersDTO getBoards(Long idPlayer){
       Set<BoardDTO> boards;
       Player player = playerRepository.findById(idPlayer).orElseThrow(RuntimeException::new);
       boards =  player.getBoards().stream().map(BoardDTO::new).collect(Collectors.toSet());

       return new BoardsByPlayersDTO(boards);
    }

    public AchievementCompleteDTO redeemAchievement(AchievementCompleteForm form) {
        Player player = playerRepository.findById(form.getId_user()).orElseThrow(RuntimeException::new);
        Achievement achievement = achievementRepository.findById(form.getId_achievement()).orElseThrow(RuntimeException::new);

        boolean playerContainAchiev = player.getAchievements().contains(achievement);
        if(player.getPoints() < achievement.getPoints() || playerContainAchiev){
            throw new RuntimeException("sem pontos suficientes");
        }

        player.setPoints(player.getPoints() - achievement.getPoints());
        achievement.getPlayers().add(player);

        achievementRepository.save(achievement);

        return new AchievementCompleteDTO(achievement);
    }

    public AchievementsByPlayer getMyAchievements(Long id_player) {
        Player player = playerRepository.findById(id_player).orElseThrow(RuntimeException::new);

        Set<Achievement> achivementSet = player.getAchievements();

        return new AchievementsByPlayer(achivementSet);
    }

  public PlayerDTO getPlayer(Long id_player) {
        Player player = playerRepository.findById(id_player).orElseThrow(RuntimeException::new);

        return new PlayerDTO(player);
  }
}
