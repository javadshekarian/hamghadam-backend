package ir.hamghadam.hamghadam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import ir.hamghadam.hamghadam.utils.IdEntity;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends AuditedDto implements IdEntity<UUID> {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    @NotBlank(message = "username.is.required")
    @Size(max = 255, message = "username.must.be.at.most.255.characters")
    private String username;

    @NotBlank(message = "password.is.required")
    @Size(min = 6, max = 255, message = "password.must.be.at.most.255.characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Size(max = 255, message = "firstname.must.be.at.most.255.characters")
    private String firstname;

    @Size(max = 255, message = "lastname.must.be.at.most.255.characters")
    private String lastname;

    @Size(max = 255, message = "city.must.be.at.most.255.characters")
    private String city;

    @Positive(message = "age.must.be.positive")
    @Max(value = 150, message = "age.must.be.at.most.150")
    @Min(value = 10, message = "age.must.be.at.least.10")
    private Integer age;


}