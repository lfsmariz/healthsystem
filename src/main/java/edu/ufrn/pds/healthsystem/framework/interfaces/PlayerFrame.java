package edu.ufrn.pds.healthsystem.framework.interfaces;

import java.util.Set;

public interface PlayerFrame {

  PlayerFrame createPlayer(String name);

  void addBoard(BoardFrame boardFrame);

  BoardFrame getBoard(Long id);

  Set<BoardFrame> getBoards();

  Set<AchievementFrame> getAchievements();

  void addPoints(Integer value);

  void removePoints(Integer value);

  Integer getPoints();

  boolean containAchievement(AchievementFrame achievementFrame);
}
