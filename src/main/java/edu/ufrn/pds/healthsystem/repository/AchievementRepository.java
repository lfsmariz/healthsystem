package edu.ufrn.pds.healthsystem.repository;

        import edu.ufrn.pds.healthsystem.entity.Achievement;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement,Long> {}