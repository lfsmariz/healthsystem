package edu.ufrn.pds.healthsystem.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPlayerForm {
    private Long id_player;
    private Long id_board;
}
