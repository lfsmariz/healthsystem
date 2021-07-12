package edu.ufrn.pds.healthsystem.repository;

import edu.ufrn.pds.healthsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> { }
