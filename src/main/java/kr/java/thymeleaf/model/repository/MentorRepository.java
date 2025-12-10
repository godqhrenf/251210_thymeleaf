package kr.java.thymeleaf.model.repository;

import kr.java.thymeleaf.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
    @Query("SELECT DISTINCT m FROM Mentor m LEFT JOIN FETCH m.mentees")
    List<Mentor> findAllWithMentees();

    @Query("SELECT m FROM Mentor m LEFT JOIN FETCH m.mentees WHERE m.id = :id")
    Optional<Mentor> findByIdWithMentees(@Param("id") Long id);
}
