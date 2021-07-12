package edu.ufrn.pds.healthsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Player extends User{

    @ManyToMany
    private Set<Board> boards;

    @ManyToMany
    private Set<Achivement> achivements;
}
