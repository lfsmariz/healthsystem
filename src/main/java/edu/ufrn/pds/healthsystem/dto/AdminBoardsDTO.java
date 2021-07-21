package edu.ufrn.pds.healthsystem.dto;

import edu.ufrn.pds.healthsystem.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
@NoArgsConstructor
public class AdminBoardsDTO {
  private List<BoardDTO> boards;

  public AdminBoardsDTO(Set<Board> boardSet){
    this.boards = boardSet.stream()
            .map(BoardDTO::new)
            .collect(Collectors.toList());
  }
}
