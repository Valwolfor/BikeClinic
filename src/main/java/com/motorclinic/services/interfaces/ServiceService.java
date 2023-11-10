package com.motorclinic.services.interfaces;

import com.motorclinic.entity.Service;

import java.util.List;

public interface ServiceService {
    Service createService(Service service);
    Service updateService(Service service);
    void deleteService(Integer id);
    Service getServiceById(Integer id);

    Service getServiceByName(String name);
    List<Service> getAllServices();
}
