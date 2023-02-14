package urjc.demo.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import urjc.demo.persistencia.dto.IPlaneMechanicReviewDto;
import urjc.demo.persistencia.entity.Plane;

import java.util.List;


/**
 * Repositorio para productos.
 *
 * @author J. Manuel Colmenar
 */
public interface PlaneRepository extends JpaRepository<Plane, Long> {

    @Query(value = "select p.registration , name , surnames from plane p inner join review r on p.id = r.plane_id inner join mechanic m on m.id = r.mechanic_id ", nativeQuery = true)
    List<IPlaneMechanicReviewDto> findPlaneByMechanicReview();
}
