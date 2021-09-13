package edu.ufrn.pds.healthsystem.dto;

import edu.ufrn.pds.healthsystem.entity.Achievement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AchievementDTO {
    private Long id;
    private String name;
    private Integer points;
    private Integer plan_type;
    private String board_name;

    public AchievementDTO(Achievement achievement) {
        this.id = achievement.getId();
        this.name = achievement.getName();
        this.points = achievement.getPoints();
        this.plan_type = achievement.getPlanType();
        this.board_name = achievement.getBoard().getName();
    }
}
