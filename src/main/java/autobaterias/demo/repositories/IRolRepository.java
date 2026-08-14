package autobaterias.demo.repositories;

import autobaterias.demo.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repository interface for managing {@link Rol} entities.
 *
 * <p>Provides CRUD operations and custom queries related to
 * roles stored inn the database</p>
 *
 * @author Manuel Noreña Cardona
 * @version 1.0.0
 */
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByName(String rolName);
}
