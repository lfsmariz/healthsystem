package edu.ufrn.pds.healthsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Achivement {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    private Set<Player> players;
}
