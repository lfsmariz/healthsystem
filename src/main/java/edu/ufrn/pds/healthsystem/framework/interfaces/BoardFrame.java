package edu.ufrn.pds.healthsystem.framework.interfaces;

import java.time.LocalDate;
import java.util.Set;

public interface BoardFrame {

  Long getId();

  Set<AchievementFrame> getAchievements();

  void addAchievement(AchievementFrame achievementFrame);
}
