package edu.ufrn.pds.healthsystem.dto;

import edu.ufrn.pds.healthsystem.entity.Board;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private String name;
    private Long id_admin;
    private Long id_board;
    private LocalDate date_end;

    public BoardDTO(Board board){
        this.name = board.getName();
        this.id_admin = board.getAdmin().getId();
        this.id_board = board.getId();
        this.date_end = board.getDateEnd();
    }
}
