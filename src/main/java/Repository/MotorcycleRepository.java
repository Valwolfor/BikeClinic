package Repository;

import Beans.Customer;
import Beans.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {

    Motorcycle findByPlate (String plate);

    Motorcycle findByOwner (Customer customer);
}
