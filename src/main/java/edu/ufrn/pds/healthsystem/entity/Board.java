package edu.ufrn.pds.healthsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board {
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
}
