package edu.ufrn.pds.healthsystem.config;

import edu.ufrn.pds.healthsystem.framework.Fidelity;
import edu.ufrn.pds.healthsystem.framework.control.AchievementControl;
import edu.ufrn.pds.healthsystem.framework.control.AdminControl;
import edu.ufrn.pds.healthsystem.framework.control.BoardControl;
import edu.ufrn.pds.healthsystem.framework.control.PlayerControl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigFidelity {

  @Bean
  Fidelity fidelityConfigAcademia(){

    PlayerControl playerControl = new PlayerControl();
    AdminControl adminControl = new AdminControl();
    BoardControl boardControl = new BoardControl(true, 10);
    AchievementControl achievementControl = new AchievementControl(true);

    return Fidelity.builder()
            .achievementControl(achievementControl)
            .playerControl(playerControl)
            .boardControl(boardControl)
            .adminControl(adminControl)
            .build();
  }

}
