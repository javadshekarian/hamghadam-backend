
package ir.hamghadam.hamghadam.service;

import ir.hamghadam.hamghadam.database.jpa.Note;
import ir.hamghadam.hamghadam.database.repository.NoteRepository;
import ir.hamghadam.hamghadam.dto.NoteDto;
import ir.hamghadam.hamghadam.mapper.NoteMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    @Transactional
    public NoteDto create(UUID userId, NoteDto noteDto) {
        Note note = new Note();
        NoteMapper.mergeInto(noteDto, note);
        note.setFkUserId(userId);

        return NoteMapper.toDto(noteRepository.save(note));
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public NoteDto findById(UUID id) {
        return NoteMapper.toDto(getNote(id));
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public List<NoteDto> findAllSpecificUserNotes(UUID userId) {
        return noteRepository
                .findByUser_IdOrderByCreatedAtDesc(userId)
                .stream()
                .map(NoteMapper::toDto)
                .toList();
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public List<NoteDto> findAll() {
        return noteRepository.findAll()
                .stream()
                .map(NoteMapper::toDto)
                .toList();
    }

    @Transactional
    public NoteDto update(UUID id, NoteDto noteDto) {
        Note note = getNote(id);
        NoteMapper.mergeInto(noteDto, note);

        return NoteMapper.toDto(noteRepository.save(note));
    }

    @Transactional
    public void delete(UUID id) {
        Note note = getNote(id);
        noteRepository.delete(note);
    }

    private Note getNote(UUID id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "note.not.found"
                ));
    }
}
