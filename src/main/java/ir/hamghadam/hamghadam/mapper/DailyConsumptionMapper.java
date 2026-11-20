package ir.hamghadam.hamghadam.mapper;

import ir.hamghadam.hamghadam.database.jpa.DailyConsumption;
import ir.hamghadam.hamghadam.dto.DailyConsumptionDto;

public final class DailyConsumptionMapper {
    private DailyConsumptionMapper() {}

    public static DailyConsumptionDto toDto(DailyConsumption entity) {
        if (entity == null) return null;

        return DailyConsumptionDto.builder()
                .id(entity.getId())
                .fkUserId(entity.getFkUserId())
                .amount(entity.getAmount())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .deletedAt(entity.getDeletedAt())
                .createdBy(entity.getCreatedBy())
                .updatedBy(entity.getUpdatedBy())
                .deletedBy(entity.getDeletedBy())
                .build();
    }

    public static void mergeInto (DailyConsumptionDto dto, DailyConsumption entity) {
        if (dto.getAmount() == null) dto.setAmount(entity.getAmount());
    }
}
