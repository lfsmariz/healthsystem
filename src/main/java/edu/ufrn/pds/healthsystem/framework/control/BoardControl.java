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
public class BoardControl {
  private boolean fixedValue;

  private Integer value;


  public void completeTask(PlayerFrame playerFrame, Integer pts) {

    if (fixedValue){
      playerFrame.addPoints(value);
    } else {
      playerFrame.addPoints(pts);
    }

  }


  public Set<AchievementFrame> getAchievements(BoardFrame boardFrame){
    return  boardFrame.getAchievements();
  }


}
