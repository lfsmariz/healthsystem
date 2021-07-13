package edu.ufrn.pds.healthsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Admin extends User{

    @OneToMany(
            mappedBy = "admin",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Board> boards;

    public Admin(String name){
        super(name);
    }
}
