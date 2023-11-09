package Repository;

import Beans.Product;
import Beans.RecordServiceProduct;
import Beans.Service;
import Beans.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<RecordServiceProduct, Long> {
    List<RecordServiceProduct> findByOrder(ServiceOrder order);
    List<RecordServiceProduct> findByService(Service service);
    List<RecordServiceProduct> findByProduct(Product product);
    List<RecordServiceProduct> findByIsApprovedTrue();
    List<RecordServiceProduct> findByIsApprovedFalse();


}
