package edu.ufrn.pds.healthsystem.repository;

import edu.ufrn.pds.healthsystem.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {}
