package edu.ufrn.pds.healthsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private List<Achivement> achivements;
}
