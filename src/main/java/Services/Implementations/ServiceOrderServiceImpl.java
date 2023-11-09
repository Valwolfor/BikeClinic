package Services.Implementations;

import Beans.ServiceOrder;
import Repository.ServiceOrderRepository;
import Services.Interfaces.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ServiceOrderServiceImpl implements ServiceOrderService {

    private final ServiceOrderRepository repository;

    @Autowired
    public ServiceOrderServiceImpl(ServiceOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceOrder createServiceOrder(ServiceOrder serviceOrder) {
        return repository.save(serviceOrder);
    }

    @Override
    public ServiceOrder updateServiceOrder(ServiceOrder serviceOrder) {
        ServiceOrder oldServiceOrder = repository.findById(serviceOrder.getId()).orElse(null);
        if (oldServiceOrder == null) {
            oldServiceOrder.setAdvance(serviceOrder.getAdvance());
            oldServiceOrder.setAdvanceValue(serviceOrder.getAdvanceValue());
            oldServiceOrder.setRecordSP(serviceOrder.getRecordSP());
            oldServiceOrder.setDocuments(serviceOrder.getDocuments());
            oldServiceOrder.setRouteAuthorization(serviceOrder.getRouteAuthorization());
        }
        return repository.save(oldServiceOrder);
    }

    @Override
    public void deleteServiceOrder(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ServiceOrder getServiceOrderById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public ServiceOrder getServiceOrderByDate(Date date) {
        return repository.findByDate(date);
    }

    @Override
    public ServiceOrder getByDateBetween(Date start, Date end) {
        return repository.findByDateBetween(start, end);
    }

    @Override
    public List<ServiceOrder> getByCustomerId(Integer customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public List<ServiceOrder> getByMchanicId(Integer mechanicId) {
        return repository.findByMchanicId(mechanicId);
    }

    @Override
    public List<ServiceOrder> getByPlate(String plate) {
        return repository.findByMotorcyclePlate(plate);
    }

    @Override
    public List<ServiceOrder> getAllUsers() {
        return repository.findAll();
    }
}
