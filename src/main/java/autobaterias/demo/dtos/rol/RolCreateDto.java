package autobaterias.demo.dtos.rol;

import lombok.*;

/**
 * Represents de body of the request for create any rol
 *
 * @author Manuel Noreña Cardona
 * @version 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolCreateDto {
    /**
     * Represents the name of the role in the create request
     */
    private String name;
}
