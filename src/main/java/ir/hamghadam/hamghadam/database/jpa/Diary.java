package ir.hamghadam.hamghadam.database.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Entity
@Table(name = "diaries")
@SQLRestriction("deleted_at IS NULL")
@Getter
@Setter
public class Diary extends BaseEntity {
    @Column(name = "memory", nullable = false, columnDefinition = "TEXT")
    private String memory;

    @Column(name = "importance", nullable = false)
    private Integer importance;

    @Column(name = "fk_user_id", nullable = false)
    private UUID fkUserId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_user_id", insertable = false, updatable = false)
    private User user;
}
