package edu.ufrn.pds.healthsystem.entity;

import edu.ufrn.pds.healthsystem.form.AchievementForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    private Long id;

    private String name;

    private Integer points;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id", referencedColumnName = "board_id")
    private Board board;

    @ManyToMany
    @JoinTable(name = "players_achievements", joinColumns = @JoinColumn(name = "achievement_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Player> players;

    public Achievement(AchievementForm achievementForm, Board board){
        this.name = achievementForm.getName();
        this.points = achievementForm.getPoints();
        this.board = board;
    }
}
