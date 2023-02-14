package urjc.demo.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import urjc.demo.persistencia.dto.IPlaneMechanicReviewDto;
import urjc.demo.persistencia.entity.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {



    @Query(value = " select f.* from airport a inner join flight f on f.departure_airport_id = a.id where city = :city and departure_date = :date order by departure_date desc", nativeQuery = true)
    List<Flight> findFlightByCityAndDepartureDate(@Param("city") String city , @Param("date") LocalDateTime date );
}
