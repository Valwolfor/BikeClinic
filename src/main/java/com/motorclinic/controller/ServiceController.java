package com.motorclinic.controller;

import com.motorclinic.entity.Service;
import com.motorclinic.services.interfaces.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        List<Service> services = serviceService.getAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable Integer id) {
        Service service = serviceService.getServiceById(id);
        return (service != null) ?
                new ResponseEntity<>(service, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Service> createService(@RequestBody Service service) {
        Service createdService = serviceService.createService(service);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(@PathVariable Integer id, @RequestBody Service service) {
        service.setIdService(id);
        Service updatedService = serviceService.updateService(service);
        return (updatedService != null) ?
                new ResponseEntity<>(updatedService, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Integer id) {
        serviceService.deleteService(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Otros métodos de punto final según sea necesario
}
