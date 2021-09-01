package edu.ufrn.pds.healthsystem.framework.control;

import edu.ufrn.pds.healthsystem.framework.interfaces.AchievementFrame;
import edu.ufrn.pds.healthsystem.framework.interfaces.AdminFrame;
import edu.ufrn.pds.healthsystem.framework.interfaces.BoardFrame;
import edu.ufrn.pds.healthsystem.framework.interfaces.PlayerFrame;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class AdminControl {

  public BoardFrame createBoard(AdminFrame adminFrame, String name, LocalDate date){
    return adminFrame.createBoard(name, date);
  }

  public AchievementFrame createAchievement(AdminFrame adminFrame, String name, Integer pts, Long idBoard){

    return adminFrame.addAchievement(name, pts, idBoard);
  }

  public void addPlayerBoard(PlayerFrame playerFrame, BoardFrame boardFrame) {

    playerFrame.addBoard(boardFrame);
  }
}
