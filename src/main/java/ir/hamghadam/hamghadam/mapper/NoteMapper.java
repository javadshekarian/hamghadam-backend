package ir.hamghadam.hamghadam.mapper;

import ir.hamghadam.hamghadam.database.jpa.Note;
import ir.hamghadam.hamghadam.dto.NoteDto;

public final class NoteMapper {
    private NoteMapper() {}

    public static NoteDto toDto (Note entity) {
        if (entity == null) return null;
        NoteDto dto = new NoteDto();
        dto.setId(entity.getId());
        dto.setContent(entity.getContent());
        dto.setImportance(entity.getImportance());


        return NoteDto.builder()
                .id(entity.getId())
                .importance(entity.getImportance())
                .content(entity.getContent())
                .fkUserId(entity.getFkUserId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .deletedAt(entity.getDeletedAt())
                .createdBy(entity.getCreatedBy())
                .updatedBy(entity.getUpdatedBy())
                .deletedBy(entity.getDeletedBy())
                .build();
    }

    public static void mergeInto (NoteDto dto, Note entity) {
        if (dto.getContent() != null)
            entity.setContent(dto.getContent());
        if (dto.getImportance() != null)
            entity.setImportance(dto.getImportance());
        if (dto.getIsPublic() != null)
            entity.setIsPublic(dto.getIsPublic());
    }
}
