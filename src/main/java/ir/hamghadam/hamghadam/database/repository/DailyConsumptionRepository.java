package ir.hamghadam.hamghadam.database.repository;

import ir.hamghadam.hamghadam.database.jpa.DailyConsumption;
import ir.hamghadam.hamghadam.database.jpa.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DailyConsumptionRepository extends JpaRepository<DailyConsumption, UUID> {
    List<DailyConsumption> findByUser_IdOrderByCreatedAtDesc(UUID userId);
    Optional<Note> findByIdAndFkUserId(UUID id, UUID fkUserId);
}
