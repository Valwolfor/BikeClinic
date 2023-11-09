package Repository;

import Beans.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByMotorcycleId (Integer id);
}
