package edu.ufrn.pds.healthsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Achievement {
    @Id
    @GeneratedValue
    @Column(name = "achievement_id")
    private Long id;

    private String name;

    private Integer points;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id", referencedColumnName = "board_id", insertable = false, updatable = false)
    private Board board;

    @ManyToMany
    @JoinTable(name = "players_achievements", joinColumns = @JoinColumn(name = "achievement_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Player> players;
}
