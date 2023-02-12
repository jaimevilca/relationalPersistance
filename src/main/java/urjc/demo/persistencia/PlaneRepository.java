package urjc.demo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repositorio para productos.
 *
 *  @author J. Manuel Colmenar
 */
public interface PlaneRepository extends JpaRepository<Plane, Long> {

}
