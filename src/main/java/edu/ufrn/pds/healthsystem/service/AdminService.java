package edu.ufrn.pds.healthsystem.service;

import edu.ufrn.pds.healthsystem.dto.AchievementDTO;
import edu.ufrn.pds.healthsystem.dto.AdminDTO;
import edu.ufrn.pds.healthsystem.dto.BoardDTO;
import edu.ufrn.pds.healthsystem.entity.Achievement;
import edu.ufrn.pds.healthsystem.entity.Admin;
import edu.ufrn.pds.healthsystem.entity.Board;
import edu.ufrn.pds.healthsystem.form.AchievementForm;
import edu.ufrn.pds.healthsystem.form.AdminForm;
import edu.ufrn.pds.healthsystem.form.BoardForm;
import edu.ufrn.pds.healthsystem.repository.AchievementRepository;
import edu.ufrn.pds.healthsystem.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ufrn.pds.healthsystem.repository.AdminRepository;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final BoardRepository boardRepository;
    private final AchievementRepository achievementRepository;

    @Autowired
    AdminService(AdminRepository adminRepository, BoardRepository boardRepository, AchievementRepository achievementRepository){
        this.adminRepository = adminRepository;
        this.boardRepository = boardRepository;
        this.achievementRepository = achievementRepository;
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

        var ach = achievementRepository.save(achievement);

        return new AchievementDTO(ach.getId(), ach.getName(), ach.getPoints(), ach.getBoard().getName());
    }
}
