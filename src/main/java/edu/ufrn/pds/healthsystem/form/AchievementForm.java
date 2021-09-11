package edu.ufrn.pds.healthsystem.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class AchievementForm {
    private Long id_admin;
    private Long id_board;
    private String name;
    private Integer points;
    private Integer planType;
}
