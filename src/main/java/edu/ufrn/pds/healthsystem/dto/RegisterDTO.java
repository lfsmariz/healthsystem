package edu.ufrn.pds.healthsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {

    private Long id_player;
    private String name_player;
    private Long id_board;
    private String name_board;

}
