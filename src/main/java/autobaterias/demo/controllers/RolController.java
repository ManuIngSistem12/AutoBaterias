package autobaterias.demo.controllers;

import autobaterias.demo.dtos.rol.RolCreateDto;
import autobaterias.demo.dtos.rol.RolResponseDto;
import autobaterias.demo.dtos.rol.RolUpdateDto;
import autobaterias.demo.entities.Rol;
import autobaterias.demo.services.IRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * REST controller responsible for managing role-related operations.
 *
 * <p>Provides endpoints for creating, retrieving, updating,
 * and deleting roles.</p>
 *
 * @author Manuel Noreña Cardona
 * @since 1.0.0
 */
@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolController {

    /**
     * Service layer used to manage roles.
     */
    private final IRolService rolService;

    /**
     * Retrieves all roles.
     *
     * @return a list of role response DTOs
     */
    @GetMapping
    public ResponseEntity<List<RolResponseDto>> findAll(){
        List<RolResponseDto> response = rolService.findAll().stream()
                .map(this::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    /**
     * Retrieves a role by its identifier.
     *
     * @param id the role identifier
     * @return the role if found, otherwise a 404 response
     */
    @GetMapping("/{id}")
    public ResponseEntity<RolResponseDto> findById(@PathVariable Integer id){
        return rolService.findById(id)
                .map(this::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new role.
     *
     * @param request the role creation request data
     * @return the created role with HTTP 201 status
     */
    @PostMapping
    public ResponseEntity<RolResponseDto> save(@RequestBody RolCreateDto request){
        Rol rol = new Rol();
        rol.setName(request.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(rolService.save(rol)));
    }

    /**
     * Updates an existing role.
     *
     * @param id the identifier of the role to update
     * @param request the updated role data
     * @return the updated role if found, otherwise a 404 response
     */
    @PutMapping("/{id}")
    public ResponseEntity<RolResponseDto> update(@PathVariable Integer id, @RequestBody RolUpdateDto request){
        Rol rol = new Rol();
        rol.setName(request.getName());

        return rolService.update(id, rol)
                .map(this::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Deletes a role by its identifier.
     *
     * @param id the role identifier
     * @return HTTP 204 if deleted successfully,
     * otherwise HTTP 404 if the role does not exist
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        return rolService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    /**
     * Converts a {@link Rol} entity into a {@link RolResponseDto}.
     *
     * @param rol the role entity to convert
     * @return the corresponding response DTO
     */
    private RolResponseDto toResponse(Rol rol){
        RolResponseDto response = new RolResponseDto();
        response.setId(rol.getId());
        response.setName(rol.getName());
        return response;
    }
}
