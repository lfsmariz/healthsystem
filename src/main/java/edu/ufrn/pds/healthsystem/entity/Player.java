package edu.ufrn.pds.healthsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Player extends User{

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
}
