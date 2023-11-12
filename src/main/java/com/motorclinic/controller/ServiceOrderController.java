package com.motorclinic.controller;

import com.motorclinic.entity.ServiceOrder;
import com.motorclinic.services.interfaces.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-orders")
public class ServiceOrderController {

    private final ServiceOrderService serviceOrderService;

    @Autowired
    public ServiceOrderController(ServiceOrderService serviceOrderService) {
        this.serviceOrderService = serviceOrderService;
    }
    //Checked
    @GetMapping
    public ResponseEntity<List<ServiceOrder>> getAllServiceOrders() {
        List<ServiceOrder> serviceOrders = serviceOrderService.getAllUsers();
        return new ResponseEntity<>(serviceOrders, HttpStatus.OK);
    }

    //Check
    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrder> getServiceOrderById(@PathVariable Long id) {
        ServiceOrder serviceOrder = serviceOrderService.getServiceOrderById(id);
        return (serviceOrder != null) ?
                new ResponseEntity<>(serviceOrder, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Checked
    @PostMapping
    public ResponseEntity<ServiceOrder> createServiceOrder(@RequestBody ServiceOrder serviceOrder) {
        ServiceOrder createdServiceOrder = serviceOrderService.createServiceOrder(serviceOrder);
        return new ResponseEntity<>(createdServiceOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceOrder> updateServiceOrder(@PathVariable Long id, @RequestBody ServiceOrder serviceOrder) {
        serviceOrder.setId(id);
        ServiceOrder updatedServiceOrder = serviceOrderService.updateServiceOrder(serviceOrder);
        return (updatedServiceOrder != null) ?
                new ResponseEntity<>(updatedServiceOrder, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Check
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceOrder(@PathVariable Long id) {
        serviceOrderService.deleteServiceOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //TODO: metodos por agregar
}
