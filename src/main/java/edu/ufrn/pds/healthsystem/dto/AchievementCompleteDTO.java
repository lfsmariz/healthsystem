package edu.ufrn.pds.healthsystem.dto;

import edu.ufrn.pds.healthsystem.entity.Achievement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AchievementCompleteDTO {
  private String name;
  private Integer points;

  public AchievementCompleteDTO(Achievement achievement) {
    this.name = achievement.getName();
    this.points = achievement.getPoints();
  }
}
