package autobaterias.demo.services;

import autobaterias.demo.entities.Rol;
import java.util.List;
import java.util.Optional;

/**
 * Service interface that defines business operations
 * related to {@link Rol} entities.
 *
 * <p>Provides methods for creating, retrieving,
 * updating, and deleting roles within the system.</p>
 *
 * @author Manuel Noreña Cardona
 * @version  1.0.0
 */
public interface IRolService {

    /**
     * Retrives all roles stored in the system
     *
     * @return a list containing all registered roles
     */
    List<Rol> findAll();

    /**
     * Retrives a role by its identifier
     *
     * @param id the role identifier
     * @return an {@link Optional} containing the role if found,
     * otherwise an empty Optional
     */
    Optional<Rol> findById(Integer id);

    /**
     * Creates and persists a new role.
     *
     * @param rol the role to be created
     * @return the persisted role
     */
    Rol save(Rol rol);

    /**
     * Updates an existing role.
     *
     * @param id the identifier of the role to update
     * @param rol the role data to be updated
     * @return an {@link Optional} containing the updated role if
     * the role exists, otherwise an empty Optional
     */
    Optional<Rol> update(Integer id, Rol rol);

    /**
     * Deletes a role by its identifier.
     *
     * @param id the identifier of the role to delete
     * @return {@code true} if the role was deleted successfully;
     * {@code false} otherwise
     */
    boolean delete(Integer id);
}
