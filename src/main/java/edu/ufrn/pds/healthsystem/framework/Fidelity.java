package edu.ufrn.pds.healthsystem.framework;

import edu.ufrn.pds.healthsystem.framework.control.AchievementControl;
import edu.ufrn.pds.healthsystem.framework.control.AdminControl;
import edu.ufrn.pds.healthsystem.framework.control.BoardControl;
import edu.ufrn.pds.healthsystem.framework.control.PlayerControl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Fidelity {

  private PlayerControl playerControl;
  private AchievementControl achievementControl;
  private AdminControl adminControl;
  private BoardControl boardControl;

  Fidelity(PlayerControl playerControl, AchievementControl achievementControl, AdminControl adminControl, BoardControl boardControl) {
    this.playerControl = playerControl;
    this.achievementControl = achievementControl;
    this.adminControl = adminControl;
    this.boardControl = boardControl;
  }

  public static FidelityBuilder builder() {
    return new FidelityBuilder();
  }

  public static class FidelityBuilder {
    private PlayerControl playerControl;
    private AchievementControl achievementControl;
    private AdminControl adminControl;
    private BoardControl boardControl;

    FidelityBuilder() {
    }

    public FidelityBuilder playerControl(PlayerControl playerControl) {
      this.playerControl = playerControl;
      return this;
    }

    public FidelityBuilder achievementControl(AchievementControl achievementControl) {
      this.achievementControl = achievementControl;
      return this;
    }

    public FidelityBuilder adminControl(AdminControl adminControl) {
      this.adminControl = adminControl;
      return this;
    }

    public FidelityBuilder boardControl(BoardControl boardControl) {
      this.boardControl = boardControl;
      return this;
    }

    public Fidelity build() {
      return new Fidelity(playerControl, achievementControl, adminControl, boardControl);
    }

    public String toString() {
      return "Fidelity.FidelityBuilder(playerControl=" + this.playerControl + ", achievementControl=" + this.achievementControl + ", adminControl=" + this.adminControl + ", boardControl=" + this.boardControl + ")";
    }
  }
}
