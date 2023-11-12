package com.motorclinic.services.interfaces;

import com.motorclinic.entity.Service;

import java.util.List;

public interface ServiceService {
    Service createService(Service service);
    Service updateService(Service service);
    void deleteService(Long id);
    Service getServiceById(Long id);

    Service getServiceByName(String name);
    List<Service> getAllServices();
}
