package ir.hamghadam.hamghadam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import ir.hamghadam.hamghadam.utils.IdEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DiaryDto extends AuditedDto implements IdEntity<UUID> {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID fkUserId;

    @NotBlank(message = "memory.is.required")
    private String memory;

    @NotBlank(message = "importance.is.required")
    @Min(value = 0, message = "importance.must.be.at.least.0")
    @Max(value = 100, message = "importance.must.be.at.most.100")
    private Integer importance;

    private Boolean isPublic = false;
}
