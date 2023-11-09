package Repository;

import Beans.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
    ServiceOrder findByDate(Date date);
    ServiceOrder findByDateBetween(Date start, Date end);
    @Query("SELECT so FROM ServiceOrder so WHERE so.customerId = :customerId")
    List<ServiceOrder> findByCustomerId(@Param("customerId") Integer customerId);
    @Query("SELECT so FROM ServiceOrder so WHERE so.mechanicId = :mechanicId")
    List<ServiceOrder> findByMchanicId(@Param("mechanicId") Integer mechanicId);

    List<ServiceOrder> findByMotorcyclePlate (String plate);

}
