package edu.ufrn.pds.healthsystem.repository;

import edu.ufrn.pds.healthsystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
