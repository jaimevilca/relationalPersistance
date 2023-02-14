package urjc.demo.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import urjc.demo.persistencia.dto.IPlaneMechanicReviewDto;
import urjc.demo.persistencia.entity.Airport;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {


}
