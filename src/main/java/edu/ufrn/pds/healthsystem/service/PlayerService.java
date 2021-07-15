package edu.ufrn.pds.healthsystem.service;

import edu.ufrn.pds.healthsystem.dto.BoardDTO;
import edu.ufrn.pds.healthsystem.dto.BoardsByPlayersDTO;
import edu.ufrn.pds.healthsystem.dto.PlayerDTO;
import edu.ufrn.pds.healthsystem.entity.Player;
import edu.ufrn.pds.healthsystem.form.PlayerForm;
import edu.ufrn.pds.healthsystem.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public PlayerDTO create(PlayerForm playerForm){
        Player player = new Player(playerForm.getName());
        Player p = playerRepository.save(player);

        return new PlayerDTO(p);
    }

    public PlayerDTO completeTask(Long idPlayer){
        Player player = playerRepository.findById(idPlayer).orElseThrow(RuntimeException::new);
        player.setPoints( player.getPoints() + 1);

        Player p = playerRepository.save(player);

        return new PlayerDTO(p);
    }

    public BoardsByPlayersDTO getBoards(Long idPlayer){
       Set<BoardDTO> boards;
       Player player = playerRepository.findById(idPlayer).orElseThrow(RuntimeException::new);
       boards =  player.getBoards().stream().map(BoardDTO::new).collect(Collectors.toSet());

       return new BoardsByPlayersDTO(boards);
    }
}
