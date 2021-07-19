package edu.ufrn.pds.healthsystem.dto;

import edu.ufrn.pds.healthsystem.entity.Achievement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class AchievementsByPlayer {

  private Set<AchievementCompleteDTO> achievements_complete;

  public AchievementsByPlayer(Set<Achievement> achievementSet){
    this.achievements_complete = achievementSet.stream()
            .map(AchievementCompleteDTO::new)
            .collect(Collectors.toSet());
  }
}
