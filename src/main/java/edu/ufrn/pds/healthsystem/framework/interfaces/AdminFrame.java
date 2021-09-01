package edu.ufrn.pds.healthsystem.framework.interfaces;

import java.time.LocalDate;
import java.util.Set;

public interface AdminFrame {

  AchievementFrame addAchievement(String name, Integer points, Long idBoard);

  BoardFrame createBoard (String name, LocalDate dateFinal);

  BoardFrame getBoard( Long id );

  Set<BoardFrame> getBoards();
}
