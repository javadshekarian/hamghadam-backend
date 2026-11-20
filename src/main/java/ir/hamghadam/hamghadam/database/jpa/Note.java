package ir.hamghadam.hamghadam.database.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "notes")
@Getter
@Setter
public class Note extends BaseEntity {
    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "is_public")
    private Boolean isPublic = false;

    @Column(name = "importance")
    @Min(0)
    @Max(100)
    private Integer importance;

    @Column(name = "fk_user_id", nullable = false)
    private UUID fkUserId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_user_id", insertable = false, updatable = false)
    private User user;
}
