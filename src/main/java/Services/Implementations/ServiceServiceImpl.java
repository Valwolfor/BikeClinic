package Services.Implementations;

import Beans.Service;
import Repository.ServiceRepository;
import Services.Interfaces.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository repository;

    @Autowired
    public ServiceServiceImpl(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Service createService(Service service) {
        return repository.save(service);
    }

    @Override
    public Service updateService(Service service) {
        Service oldService = repository.findById(service.getIdService()).orElse(null);
        if (oldService != null) {
            oldService.setServiceName(service.getServiceName());
            oldService.setServiceDetail(service.getServiceDetail());
            oldService.setServiceValue(service.getServiceValue());
        }
        assert oldService != null;
        return repository.save(oldService);
    }

    @Override
    public void deleteService(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Service getServiceById(Integer id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Service getServiceByName(String name) {
        return repository.findSeviceByName(name);
    }

    @Override
    public List<Service> getAllServices() {
        return repository.findAll();
    }
}
