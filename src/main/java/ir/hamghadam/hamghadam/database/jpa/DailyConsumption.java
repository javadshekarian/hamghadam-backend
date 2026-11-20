package ir.hamghadam.hamghadam.database.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Entity
@Table(name = "daily_consumptions")
@SQLRestriction("deleted_at IS NULL")
@Getter
@Setter
public class DailyConsumption extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "fk_user_id", nullable = false)
    private UUID fkUserId;

    @Column(name = "amount", nullable = false)
    private Double amount;
}
