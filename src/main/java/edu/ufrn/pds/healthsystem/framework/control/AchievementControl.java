package edu.ufrn.pds.healthsystem.framework.control;

import edu.ufrn.pds.healthsystem.framework.interfaces.AchievementFrame;
import edu.ufrn.pds.healthsystem.framework.interfaces.PlayerFrame;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AchievementControl {

  private boolean noNegativePoints;


  public void redeemAchievement(PlayerFrame playerFrame, AchievementFrame achievementFrame) {

    if (noNegativePoints){
      if (playerFrame.getPoints() < achievementFrame.getPoints() || !playerFrame.canGetAchievement(achievementFrame)){
        throw new RuntimeException("Usuário não pode resgatar achievement");
      } else {
        playerFrame.removePoints(achievementFrame.getPoints());
        achievementFrame.associatePlayer(playerFrame);
      }
    } else {
      playerFrame.removePoints(achievementFrame.getPoints());
      achievementFrame.associatePlayer(playerFrame);
    }
  }


}
