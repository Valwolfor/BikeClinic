package com.motorclinic.services.interfaces;

import com.motorclinic.entity.ServiceOrder;

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
