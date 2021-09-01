package edu.ufrn.pds.healthsystem.framework.control;

import edu.ufrn.pds.healthsystem.framework.interfaces.AchievementFrame;
import edu.ufrn.pds.healthsystem.framework.interfaces.BoardFrame;
import edu.ufrn.pds.healthsystem.framework.interfaces.PlayerFrame;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class PlayerControl {

  public PlayerFrame createPlayer(PlayerFrame playerFrame, String name){
    return playerFrame.createPlayer(name);
  }

  public Set<BoardFrame> getBoards(PlayerFrame playerFrame) {
    return playerFrame.getBoards();
  }

  public Set<AchievementFrame> getAchievements (PlayerFrame playerFrame) {
    return playerFrame.getAchievements();
  }

  public BoardFrame getBoardById(PlayerFrame playerFrame, Long id){
    return playerFrame.getBoard(id);
  }

}
