package edu.ufrn.pds.healthsystem.repository;

import edu.ufrn.pds.healthsystem.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface AchievementRepository extends JpaRepository<Achievement,Long> {
    @Query("select a.name as name, a.points as points, a.id as id, b.name as board_name from #{#entityName} a join a.board b where b.id = ?1")
    List<Map> findByIdBoardAndIdUser(Long idBoard, Long idUser);
}