package ir.hamghadam.hamghadam.database.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "users")
@SQLRestriction("deleted_at IS NULL")
@Getter
@Setter
public class User extends BaseEntity {
    @Column(nullable = false, unique = true, length = 255)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "firstname", length = 255)
    private String firstname;

    @Column(name = "lastname", length = 255)
    private String lastname;

    @Column(length = 255)
    private String city;

    private Integer age;
}
