package edu.ufrn.pds.healthsystem.repository;

import edu.ufrn.pds.healthsystem.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
