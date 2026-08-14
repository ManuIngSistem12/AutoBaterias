package autobaterias.demo.dtos.rol;

import lombok.*;

/**
 * It represents the body of the response to the request
 * to view the roles in our system
 *
 * @author Manuel Noreña Cardona
 * @version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolResponseDto {
    /**
     * Represent the id of a role in our system
     */
    private Integer id;

    /**
     * Represent the name of a role in our system
     */
    private String name;
}
