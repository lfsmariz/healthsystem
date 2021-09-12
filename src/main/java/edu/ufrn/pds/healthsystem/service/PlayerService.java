package edu.ufrn.pds.healthsystem.service;

import edu.ufrn.pds.healthsystem.dto.*;
import edu.ufrn.pds.healthsystem.entity.Achievement;
import edu.ufrn.pds.healthsystem.entity.Board;
import edu.ufrn.pds.healthsystem.entity.Player;
import edu.ufrn.pds.healthsystem.form.AchievementCompleteForm;
import edu.ufrn.pds.healthsystem.form.PlayerForm;
import edu.ufrn.pds.healthsystem.framework.Fidelity;
import edu.ufrn.pds.healthsystem.framework.interfaces.PlayerFrame;
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
    private final Fidelity fidelity;


    @Autowired
    PlayerService(PlayerRepository playerRepository, AchievementRepository achievementRepository, Fidelity fidelity){
        this.playerRepository = playerRepository;
        this.achievementRepository = achievementRepository;
        this.fidelity = fidelity;
    }

    public PlayerDTO create(PlayerForm playerForm){
        Player player = new Player();
        //framework
        Player playerFrame = (Player) fidelity.getPlayerControl().createPlayer(player, playerForm.getName());

        playerRepository.save(playerFrame);

        return new PlayerDTO(playerFrame);
    }

    public PlayerDTO completeTask(Long idPlayer, int value){
        Player player = playerRepository.findById(idPlayer).orElseThrow(RuntimeException::new);

        //framework
//        player.setPoints( player.getPoints() + 1);
        fidelity.getBoardControl().completeTask(player, value);

        Player p = playerRepository.save(player);

        return new PlayerDTO(p);
    }

    public BoardsByPlayersDTO getBoards(Long idPlayer){
       Set<BoardDTO> boards;
       Player player = playerRepository.findById(idPlayer).orElseThrow(RuntimeException::new);

       //framework
//       boards =  player.getBoards().stream().map(BoardDTO::new).collect(Collectors.toSet());

        Set<Board> boardSet= fidelity.getPlayerControl().getBoards(player).stream().map(b -> (Board) b).collect(Collectors.toSet());

        boards =  boardSet.stream().map(BoardDTO::new).collect(Collectors.toSet());

       return new BoardsByPlayersDTO(boards);
    }

    public AchievementCompleteDTO redeemAchievement(AchievementCompleteForm form) {
        Player player = playerRepository.findById(form.getId_user()).orElseThrow(RuntimeException::new);
        Achievement achievement = achievementRepository.findById(form.getId_achievement()).orElseThrow(RuntimeException::new);

        //framework
//        boolean playerContainAchiev = player.getAchievements().contains(achievement);
//        if(player.getPoints() < achievement.getPoints() || playerContainAchiev){
//            throw new RuntimeException("sem pontos suficientes");
//        }
//
//        player.setPoints(player.getPoints() - achievement.getPoints());
//        achievement.getPlayers().add(player);]

        fidelity.getAchievementControl().redeemAchievement(player, achievement);

        achievementRepository.save(achievement);

        return new AchievementCompleteDTO(achievement);
    }

    public AchievementsByPlayer getMyAchievements(Long id_player) {
        Player player = playerRepository.findById(id_player).orElseThrow(RuntimeException::new);

        //framework
//        Set<Achievement> achivementSet = player.getAchievements();

        Set<Achievement> achievementSet = fidelity.getPlayerControl().getAchievements(player).stream().map(a -> (Achievement) a).collect(Collectors.toSet());

        return new AchievementsByPlayer(achievementSet);
    }

  public PlayerDTO getPlayer(Long id_player) {
        Player player = playerRepository.findById(id_player).orElseThrow(RuntimeException::new);

        return new PlayerDTO(player);
  }
}
