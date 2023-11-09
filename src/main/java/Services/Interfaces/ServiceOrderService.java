package Services.Interfaces;

import Beans.ServiceOrder;
import Beans.User;
import java.util.Date;
import java.util.List;

public interface ServiceOrderService {

    ServiceOrder createServiceOrder(ServiceOrder serviceOrder);

    ServiceOrder updateServiceOrder(ServiceOrder serviceOrder);

    void deleteServiceOrder(Long id);

    ServiceOrder getServiceOrderById(Long id);

    ServiceOrder getServiceOrderByDate(Date date);

    ServiceOrder getByDateBetween(Date start, Date end);

    List<ServiceOrder> getByCustomerId(Integer customerId);

    List<ServiceOrder> getByMchanicId(Integer mechanicId);

    List<ServiceOrder> getByPlate(String plate);

    List<ServiceOrder> getAllUsers();

}
