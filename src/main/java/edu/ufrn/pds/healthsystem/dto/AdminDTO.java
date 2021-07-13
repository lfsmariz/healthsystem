package edu.ufrn.pds.healthsystem.dto;

import edu.ufrn.pds.healthsystem.entity.Admin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AdminDTO {
    private Long id;
    private String name;


    public AdminDTO(Admin admin){
        id = admin.getId();
        name = admin.getName();
    }
}
