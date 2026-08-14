package autobaterias.demo.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a role within the system.
 *
 * A role defines a set of permissions that can be assigned
 * to one or more users for authorization purposes
 *
 * @author Manuel Noreña Cardona
 * @version 1.0.0
 */
@Entity
@Table(name = "rol")
@Data
@AllArgsConstructor@NoArgsConstructor
public class Rol {

    /**
     * Unique identifier of the role.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Name of the role.
     * Must be unique and cannot be null
     *
     * Examples:
     * ADMIN, USER, SECURITY...
     */
    @Column(nullable = false, unique = true, length = 50)
    private String name;
}
