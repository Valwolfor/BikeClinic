package com.motorclinic.services.interfaces;

import com.motorclinic.entity.Customer;
import com.motorclinic.entity.DTO.ServiceOrderDTO;
import com.motorclinic.entity.ServiceOrder;
import com.motorclinic.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ServiceOrderService {

    ServiceOrder createServiceOrder(ServiceOrder serviceOrder);

    ServiceOrder updateServiceOrder(ServiceOrder serviceOrder);

    void deleteServiceOrder(Long id);

    ServiceOrderDTO getServiceOrderById(Long serviceOrderId);

    List<ServiceOrder> getServiceOrderByDate(LocalDate date);

    List<ServiceOrder> getByDateBetween(LocalDate start, LocalDate end);

    List<ServiceOrder> getByCustomerId(Customer customer);

    List<ServiceOrder> getByMchanicId(User mechanic);

    List<ServiceOrder> getByPlate(String plate);

    List<ServiceOrder> getAllUsers();

}
