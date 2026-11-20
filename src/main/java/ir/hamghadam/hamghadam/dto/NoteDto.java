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
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class NoteDto extends AuditedDto implements IdEntity<UUID> {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID fkUserId;

    @NotBlank(message = "content.is.required")
    private String content;

    @Max(value = 100, message = "importance.must.be.at.most.100")
    @Min(value = 0, message = "importance.must.be.at.least.0")
    private Integer importance;

    private Boolean isPublic = false;
}
