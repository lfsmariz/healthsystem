package edu.ufrn.pds.healthsystem.dto;

import edu.ufrn.pds.healthsystem.entity.Player;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PlayerDTO {
    private Long id;
    private String name;
    private Integer points;
    private Integer planType;

    public PlayerDTO(Player player){
        id = player.getId();
        name = player.getName();
        points = player.getPoints();
        planType = player.getPlanType();
    }
}
