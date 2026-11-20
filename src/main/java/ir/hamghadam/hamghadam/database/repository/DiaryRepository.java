package ir.hamghadam.hamghadam.database.repository;

import ir.hamghadam.hamghadam.database.jpa.Diary;
import ir.hamghadam.hamghadam.database.jpa.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DiaryRepository extends JpaRepository<Diary, UUID> {
    List<Diary> findByUser_IdOrderByCreatedAtDesc(UUID userId);
    Optional<Note> findByIdAndFkUserId(UUID id, UUID fkUserId);
}
