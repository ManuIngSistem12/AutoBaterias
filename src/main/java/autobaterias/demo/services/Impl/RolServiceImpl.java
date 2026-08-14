package autobaterias.demo.services.Impl;

import autobaterias.demo.entities.Rol;
import autobaterias.demo.repositories.IRolRepository;
import autobaterias.demo.services.IRolService;
import lombok.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link IRolService} that provides
 * business operations for {@link Rol} entities.
 *
 * <p>This service acts as an intermediary between the
 * controller layer and the repository layer, handling
 * role-related operations.</p>
 *
 * @author Manuel Noreña Cardona
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class RolServiceImpl implements IRolService {

    /**
     * Repository used to access role data.
     */
    private final IRolRepository rolRepository;

    /**
     * Retrieves all roles from the database.
     *
     * @return a list containing all roles
     */
    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    /**
     * Retrieves a role by its identifier.
     *
     * @param id the role identifier
     * @return an {@link Optional} containing the role if found,
     * otherwise an empty Optional
     */
    @Override
    public Optional<Rol> findById(Integer id) {
        return rolRepository.findById(id);
    }

    /**
     * Persists a new role in the database.
     *
     * @param rol the role to be saved
     * @return the saved role
     */
    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    /**
     * Updates an existing role.
     *
     * @param id the identifier of the role to update
     * @param rol the new role data
     * @return an {@link Optional} containing the updated role if
     * the role exists, otherwise an empty Optional
     */
    @Override
    public Optional<Rol> update(Integer id, Rol rol) {
        return rolRepository.findById(id).map(existing -> {
            existing.setName(rol.getName());
            return rolRepository.save(existing);
        });
    }

    /**
     * Deletes a role by its identifier.
     *
     * @param id the role identifier
     * @return {@code true} if the role was successfully deleted;
     * {@code false} if the role does not exist
     */
    @Override
    public boolean delete(Integer id) {
        if(!rolRepository.existsById(id))return false;
        rolRepository.deleteById(id);
        return true;
    }
}
