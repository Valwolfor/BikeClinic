package com.motorclinic.repository;

import com.motorclinic.entity.Customer;
import com.motorclinic.entity.ServiceOrder;
import com.motorclinic.entity.Status;
import com.motorclinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {

    // Encuentra todas las órdenes de servicio por placa de motocicleta
    List<ServiceOrder> findByMotorcyclePlate(String motorcyclePlate);

    // Encuentra todas las órdenes de servicio por fecha
    List<ServiceOrder> findByDate(LocalDate date);

    // Encuentra todas las órdenes de servicio entre dos fechas
    List<ServiceOrder> findByDateBetween(LocalDate startDate, LocalDate endDate);

    // Encuentra todas las órdenes de servicio por estado y fecha
    List<ServiceOrder> findByStatusAndDate(Status status, LocalDateTime date);

    // Encuentra todas las órdenes de servicio por cliente
    List<ServiceOrder> findByMotorcycle_Customer(Customer motorcycle_customer);

    // Encuentra todas las órdenes de servicio por mecánico
    List<ServiceOrder> findByMechanic(User mechanic);
}
