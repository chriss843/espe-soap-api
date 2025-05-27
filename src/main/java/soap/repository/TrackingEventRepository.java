package soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soap.model.TrackingEvent;

public interface TrackingEventRepository extends JpaRepository<TrackingEvent, Long> {
}