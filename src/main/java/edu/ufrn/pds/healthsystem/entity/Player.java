package edu.ufrn.pds.healthsystem.entity;

import edu.ufrn.pds.healthsystem.framework.interfaces.AchievementFrame;
import edu.ufrn.pds.healthsystem.framework.interfaces.BoardFrame;
import edu.ufrn.pds.healthsystem.framework.interfaces.PlayerFrame;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Setter
@NoArgsConstructor
public class Player extends User implements PlayerFrame {

    private Integer points;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Board> boards;

    @ManyToMany(mappedBy = "players")
    private Set<Achievement> achievements;

    public Player(String name) {
        super(name);
        this.points = 0;
    }

    @Override
    public PlayerFrame createPlayer(String name) {
        return new Player(name);
    }

    @Override
    public void addBoard(BoardFrame boardFrame) {
        this.getBoards().add(boardFrame);
    }

    @Override
    public BoardFrame getBoard(Long id) {
        return this.getBoards().stream().filter(b -> b.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

    @Override
    public Set<BoardFrame> getBoards() {
        return this.boards.stream().map(b -> (BoardFrame) b).collect(Collectors.toSet());
    }

    public Set<Board> getBoardsd() {
        return this.boards;
    }

    @Override
    public Set<AchievementFrame> getAchievements() {
        return this.achievements.stream().map(a -> (AchievementFrame) a).collect(Collectors.toSet());
    }

    @Override
    public void addPoints(Integer value) {
        this.setPoints(this.getPoints() + value);
    }

    @Override
    public void removePoints(Integer value) {
        this.setPoints(this.getPoints() - value);
    }

    @Override
    public Integer getPoints() {
        return this.points;
    }

    @Override
    public boolean canGetAchievement(AchievementFrame achievementFrame) {
        return true;
    }

    @Override
    public String toString() {
        return "Player{" +
                "points=" + points +
                ", boards=" + boards +
                ", achievements=" + achievements +
                '}';
    }
}
