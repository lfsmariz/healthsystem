package edu.ufrn.pds.healthsystem.entity;

import edu.ufrn.pds.healthsystem.framework.interfaces.AchievementFrame;
import edu.ufrn.pds.healthsystem.framework.interfaces.AdminFrame;
import edu.ufrn.pds.healthsystem.framework.interfaces.BoardFrame;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@NoArgsConstructor
public class Admin extends User implements AdminFrame {

    @OneToMany(
            mappedBy = "admin",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Board> boards;

    public Admin(String name){
        super(name);
    }

    @Override
    public AchievementFrame addAchievement(String name, Integer points, Long idBoard) {
        Board board = (Board) getBoard(idBoard);

        AchievementFrame achievementFrame = new Achievement(name, points, board);

        board.addAchievement(achievementFrame);

        return achievementFrame;
    }

    @Override
    public BoardFrame createBoard(String name, LocalDate dateFinal) {
        return new Board(name, this, dateFinal);
    }

    @Override
    public BoardFrame getBoard(Long id) {
        return this.boards.stream().filter(b -> b.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

    @Override
    public Set<BoardFrame> getBoards() {
        return new HashSet<>(this.boards);
    }
}
