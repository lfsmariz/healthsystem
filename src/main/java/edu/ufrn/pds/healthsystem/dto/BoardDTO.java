package edu.ufrn.pds.healthsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BoardDTO {
    private String name;
    private Long id_admin;
    private Long id_board;
    private LocalDate date_end;
}
