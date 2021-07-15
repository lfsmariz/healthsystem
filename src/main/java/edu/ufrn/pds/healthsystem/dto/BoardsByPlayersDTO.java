package edu.ufrn.pds.healthsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardsByPlayersDTO {
    private Set<BoardDTO> boardDTOSet;
}
