package edu.ufrn.pds.healthsystem.service;

import edu.ufrn.pds.healthsystem.dto.*;
import edu.ufrn.pds.healthsystem.entity.Achievement;
import edu.ufrn.pds.healthsystem.entity.Admin;
import edu.ufrn.pds.healthsystem.entity.Board;
import edu.ufrn.pds.healthsystem.entity.Player;
import edu.ufrn.pds.healthsystem.form.*;
import edu.ufrn.pds.healthsystem.repository.AchievementRepository;
import edu.ufrn.pds.healthsystem.repository.BoardRepository;
import edu.ufrn.pds.healthsystem.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ufrn.pds.healthsystem.repository.AdminRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final BoardRepository boardRepository;
    private final AchievementRepository achievementRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    AdminService(AdminRepository adminRepository, BoardRepository boardRepository, AchievementRepository achievementRepository, PlayerRepository playerRepository){
        this.adminRepository = adminRepository;
        this.boardRepository = boardRepository;
        this.achievementRepository = achievementRepository;
        this.playerRepository = playerRepository;
    }

    public AdminDTO create(AdminForm adminForm){
        Admin admin = new Admin(adminForm.getName());
        Admin a = adminRepository.save(admin);
        return new AdminDTO(a);
    }

    public BoardDTO createBoard(BoardForm boardForm){
        Admin admin = adminRepository.findById(boardForm.getId_admin()).orElseThrow(RuntimeException::new);

        Board board = new Board(boardForm.getName(), admin, boardForm.getDate_end());

        boardRepository.save(board);

        return new BoardDTO(boardForm.getName(), admin.getId(), board.getId(), board.getDateEnd());
    }

    public AchievementDTO createAchievement (AchievementForm achievementForm){
        Admin admin = adminRepository.findById(achievementForm.getId_admin()).orElseThrow(RuntimeException::new);
        Board adminBoard = admin.getBoards()
                .stream()
                .filter(b -> b.getId().equals(achievementForm.getId_board())).findFirst()
                .orElseThrow(RuntimeException::new);

        Achievement achievement = new Achievement(achievementForm, adminBoard);

        Achievement ach = achievementRepository.save(achievement);

        return new AchievementDTO(ach.getId(), ach.getName(), ach.getPoints(), ach.getBoard().getName());
    }

    public RegisterDTO registerPlayer(RegisterPlayerForm registerPlayerForm) {
        Player player = playerRepository.findById(registerPlayerForm.getId_player()).orElseThrow(RuntimeException::new);
        Board board = boardRepository.findById(registerPlayerForm.getId_board()).orElseThrow(RuntimeException::new);

        player.getBoards().add(board);
        playerRepository.save(player);

        return new RegisterDTO(player.getId(), player.getName(), board.getId(), board.getName());
    }

    public AchievementsByBoardDTO getAchievementsActiveUser(Long idBoard, Long idUser){
        Set<AchievementDTO> achievements;
        Player user = playerRepository.findById(idUser).orElseThrow(RuntimeException::new);

        Board board = user.getBoards()
                .stream()
                .filter(b -> b.getId().equals(idBoard))
                .findFirst()
                .orElseThrow(RuntimeException::new);

        achievements = board.getAchievements().stream().map(AchievementDTO::new).collect(Collectors.toSet());
//        for(Map map : listMapAchivevements) {
//            achievements.add(new AchievementDTO(
//                    map.get("id"),
//                    map.get("name"),
//                    map.get("points"),
//                    map.get("board_name")));
//        }
//
//        return achievements;



        return new AchievementsByBoardDTO(achievements);
    }

    public AdminBoardsDTO getBoards(Long idAdmin) {
        Admin admin = adminRepository.findById(idAdmin).orElseThrow(RuntimeException::new);

        return new AdminBoardsDTO(admin.getBoards());
    }

    public BoardPlayersDTO getBoardPlayers(Long idBoard) {
        Board board = boardRepository.findById(idBoard).orElseThrow(RuntimeException::new);

        return new BoardPlayersDTO(board.getPlayers());
    }

    public AdminDTO getAdmin(Long idAdmin) {
        Admin admin = adminRepository.findById(idAdmin).orElseThrow(RuntimeException::new);

        return new AdminDTO(admin);
    }
}
