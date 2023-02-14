package urjc.demo.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urjc.demo.persistencia.entity.Mechanic;

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {


}
