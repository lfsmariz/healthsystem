package edu.ufrn.pds.healthsystem.entity;

import edu.ufrn.pds.healthsystem.framework.interfaces.AchievementFrame;
import edu.ufrn.pds.healthsystem.framework.interfaces.BoardFrame;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@NoArgsConstructor
public class Board implements BoardFrame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    private Admin admin;

    @OneToMany(
            mappedBy = "board",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Achievement> achievements;

    @ManyToMany(mappedBy = "boards")
    private Set<Player> players;

    private LocalDate dateEnd;

    public Board(String name, Admin admin, LocalDate dateEnd){
        this.name = name;
        this.admin = admin;
        this.dateEnd = dateEnd;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Set<AchievementFrame> getAchievements() {
        return new HashSet<>(this.achievements);
    }

    @Override
    public void addAchievement(AchievementFrame achievementFrame) {
        this.achievements.add((Achievement) achievementFrame);
    }

    public String getName() {
        return name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }
}
