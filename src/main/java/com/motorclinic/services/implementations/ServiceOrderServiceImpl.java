package com.motorclinic.services.implementations;

import com.motorclinic.entity.Customer;
import com.motorclinic.entity.DTO.ServiceOrderDTO;
import com.motorclinic.entity.ServiceOrder;
import com.motorclinic.entity.User;
import com.motorclinic.repository.ServiceOrderRepository;
import com.motorclinic.services.interfaces.ServiceOrderService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

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
        // Buscar la orden de servicio existente en la base de datos
        ServiceOrder existingServiceOrder = repository.findById(serviceOrder.getId())
                .orElseThrow(() -> new EntityNotFoundException("Service Order not found with ID: " + serviceOrder.getId()));

        // Actualizar las propiedades de la orden de servicio existente con los valores proporcionados
        existingServiceOrder.setAdvance(serviceOrder.getAdvance());
        existingServiceOrder.setAdvanceValue(serviceOrder.getAdvanceValue());
        existingServiceOrder.setDocuments(serviceOrder.getDocuments());
        existingServiceOrder.setRouteAuth(serviceOrder.isRouteAuth());

        // Guardar la orden de servicio actualizada en la base de datos
        return repository.save(existingServiceOrder);
    }
    @Override
    public void deleteServiceOrder(Long id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                System.out.println("Service Order deleted successfully with ID: " + id);
            } else {
                throw new EntityNotFoundException("Service Order not found with ID: " + id);
            }
        } catch (Exception e) {
            System.err.println("Error deleting Service Order with ID: " + id);
            throw e;
        }
    }


    @Transactional(readOnly = true)
    public ServiceOrderDTO getServiceOrderById(Long serviceOrderId) {
        // Obtener la orden de servicio desde la base de datos por su ID
        ServiceOrder serviceOrder = repository.findById(serviceOrderId)
                .orElseThrow(() -> new EntityNotFoundException("Service Order not found with ID: " + serviceOrderId));

        // Convertir la entidad a un DTO para devolver al cliente
        return mapServiceOrderToDTO(serviceOrder);
    }
    @Override
    public List<ServiceOrder> getServiceOrderByDate(LocalDateTime date) {
        return repository.findByDate(date);
    }

    @Override
    public List<ServiceOrder> getByDateBetween(LocalDateTime start, LocalDateTime end) {
        return repository.findByDateBetween(start, end);
    }

    @Override
    public List<ServiceOrder> getByCustomerId(Customer customer) {
        return repository.findByMotorcycle_Customer(customer);
    }

    @Override
    public List<ServiceOrder> getByMchanicId(User mechanic) {
        return repository.findByMechanic(mechanic);
    }

    @Override
    public List<ServiceOrder> getByPlate(String plate) {
        return repository.findByMotorcyclePlate(plate);
    }

    @Override
    public List<ServiceOrder> getAllUsers() {
        return repository.findAll();
    }

    private ServiceOrderDTO mapServiceOrderToDTO(ServiceOrder serviceOrder) {
        ServiceOrderDTO serviceOrderDTO = new ServiceOrderDTO();

        serviceOrderDTO.setId(serviceOrder.getId());
        serviceOrderDTO.setAdvance(serviceOrder.getAdvance());
        serviceOrderDTO.setAdvanceValue(serviceOrder.getAdvanceValue());
        serviceOrderDTO.setDate(serviceOrder.getDate());
        serviceOrderDTO.setDiagnosticDesc(serviceOrder.getDiagnosticDesc());
        serviceOrderDTO.setDocuments(serviceOrder.getDocuments());
        serviceOrderDTO.setMotorcyclePlate(serviceOrder.getMotorcyclePlate());
        serviceOrderDTO.setReason(serviceOrder.getReason());
        serviceOrderDTO.setRouteAuth(serviceOrder.isRouteAuth());
        serviceOrderDTO.setMotorcycleId(serviceOrder.getMotorcycle().getId());
        serviceOrderDTO.setStatusId(serviceOrder.getStatus().getId());
        serviceOrderDTO.setMechanicId(serviceOrder.getMechanic().getId());

        return serviceOrderDTO;
    }
}
