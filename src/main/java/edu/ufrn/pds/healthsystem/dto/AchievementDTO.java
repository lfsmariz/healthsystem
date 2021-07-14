package edu.ufrn.pds.healthsystem.dto;

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
    private String board_name;

    public AchievementDTO(Object id, Object name, Object points, Object board_name) {
        this.id = Long.valueOf(String.valueOf(id));
        this.name = name.toString();
        this.points = Integer.valueOf(String.valueOf(points));
        this.board_name = board_name.toString();
    }
}
