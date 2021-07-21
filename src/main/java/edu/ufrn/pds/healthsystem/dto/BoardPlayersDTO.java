package edu.ufrn.pds.healthsystem.dto;

import edu.ufrn.pds.healthsystem.entity.Player;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class BoardPlayersDTO {
  private List<PlayerDTO> players;

  public BoardPlayersDTO(Set<Player> players){
    this.players = players.stream()
            .map(PlayerDTO::new)
            .collect(Collectors.toList());
  }
}
