package ir.hamghadam.hamghadam.mapper;

import ir.hamghadam.hamghadam.database.jpa.Diary;
import ir.hamghadam.hamghadam.dto.DiaryDto;

public final class DiaryMapper {
    private DiaryMapper() {}

    public static DiaryDto toDto (Diary entity) {
        if (entity == null) return null;

        return DiaryDto.builder()
                .id(entity.getId())
                .fkUserId(entity.getFkUserId())
                .memory(entity.getMemory())
                .importance(entity.getImportance())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .deletedAt(entity.getDeletedAt())
                .createdBy(entity.getCreatedBy())
                .updatedBy(entity.getUpdatedBy())
                .deletedBy(entity.getDeletedBy())
                .build();
    }

    public static void mergeInto (DiaryDto dto, Diary entity) {
        if (dto.getMemory() != null) entity.setMemory(dto.getMemory());
        if (dto.getImportance() != null) entity.setImportance(dto.getImportance());
    }
}
