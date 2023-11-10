package com.motorclinic.services.implementations;

import com.motorclinic.entity.Service;
import com.motorclinic.repository.ServiceRepository;
import com.motorclinic.services.interfaces.ServiceService;
import jakarta.persistence.EntityNotFoundException;
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

        if (oldService == null) {
            throw new EntityNotFoundException("Servicio no encontrado con ID: " + service.getIdService());
        }
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
