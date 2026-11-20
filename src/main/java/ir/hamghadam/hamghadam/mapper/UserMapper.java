package ir.hamghadam.hamghadam.mapper;

import ir.hamghadam.hamghadam.database.jpa.User;
import ir.hamghadam.hamghadam.dto.UserDto;

public final class UserMapper {
    private UserMapper() {}

    public static UserDto toDto(User entity) {
        if (entity == null)
            return null;

        return UserDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .firstname(entity.getFirstname())
                .lastname(entity.getLastname())
                .city(entity.getCity())
                .age(entity.getAge())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .deletedAt(entity.getDeletedAt())
                .createdBy(entity.getCreatedBy())
                .updatedBy(entity.getUpdatedBy())
                .deletedBy(entity.getDeletedBy())
                .build();
    }

    public static void mergeInto(UserDto dto, User entity) {
        if (dto.getUsername() != null)
            entity.setUsername(dto.getUsername());
        if (dto.getFirstname() != null)
            entity.setFirstname(dto.getFirstname());
        if (dto.getLastname() != null)
            entity.setLastname(dto.getLastname());
        if (dto.getCity() != null)
            entity.setCity(dto.getCity());
        if (dto.getAge() != null)
            entity.setAge(dto.getAge());
    }
}
