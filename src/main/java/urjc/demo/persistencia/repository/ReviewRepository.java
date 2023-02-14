package urjc.demo.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urjc.demo.persistencia.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {


}
