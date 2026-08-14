package autobaterias.demo.dtos.rol;

import lombok.*;

/**
 * Represents de body of the request for update any rol
 *
 * @author Manuel Noreña Cardona
 * @version 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolUpdateDto {
    /**
     * Represents the name of the role in the update request
     */
    private String name;
}
