package ir.hamghadam.hamghadam.controller;

import ir.hamghadam.hamghadam.dto.NoteDto;
import ir.hamghadam.hamghadam.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/notes/{userId}")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @PostMapping
    public ResponseEntity<NoteDto> create(
            @PathVariable UUID userId,
            @Valid @RequestBody NoteDto noteDto
    ) {
        NoteDto result = noteService.create(userId, noteDto);
        return ResponseEntity
                .created(URI.create("/api/notes" + userId + "/" + result.getId()))
                .body(result);
    }

    @GetMapping
    public ResponseEntity<List<NoteDto>> findAll(){
        return ResponseEntity.ok(noteService.findAll());
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<NoteDto> findById(
            @PathVariable UUID noteId
    ) {
        return ResponseEntity.ok(noteService.findById(noteId));
    }

    @GetMapping("/user")
    public ResponseEntity<List<NoteDto>> findByUserId(
            @PathVariable UUID userId
    ) {
        return ResponseEntity.ok(noteService.findAllSpecificUserNotes(userId));
    }
}
