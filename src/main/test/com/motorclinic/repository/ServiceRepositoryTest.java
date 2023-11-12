package com.motorclinic.repository;

import com.motorclinic.entity.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@SpringBootTest
public class ServiceRepositoryTest {

    @Autowired
    private ServiceRepository serviceRepository;

    @Test
    @Transactional
    @Rollback
    public void testSaveService() {
        // Arrange
        Service service = new Service();
        service.setServiceName("Oil Change");
        service.setServiceValue(BigDecimal.valueOf(50.0));

        // Act
        Service savedService = serviceRepository.save(service);

        // Assert
        Assertions.assertNotNull(savedService.getIdService());
        Assertions.assertEquals("Oil Change", savedService.getServiceName());
        Assertions.assertEquals(BigDecimal.valueOf(50.0), savedService.getServiceValue());
    }

    @Test
    @Transactional
    @Rollback
    public void testFindServiceById() {
        // Arrange
        Service service = new Service();
        service.setServiceName("Brake Inspection");
        service.setServiceValue(BigDecimal.valueOf(30.0));
        Service savedService = serviceRepository.save(service);

        // Act
        Service foundService = serviceRepository.findServiceById(savedService.getIdService());

        // Assert
        Assertions.assertNotNull(foundService);
        Assertions.assertEquals("Brake Inspection", foundService.getServiceName());
        Assertions.assertEquals(BigDecimal.valueOf(30.0), foundService.getServiceValue());
    }

    @Test
    @Transactional
    @Rollback
    public void testFindServiceByName() {
        // Arrange
        Service service = new Service();
        service.setServiceName("Tire Rotation");
        service.setServiceValue(BigDecimal.valueOf(20.0));
        Service savedService = serviceRepository.save(service);

        // Act
        Service foundService = serviceRepository.findSeviceByName("Tire Rotation");

        // Assert
        Assertions.assertNotNull(foundService);
        Assertions.assertEquals("Tire Rotation", foundService.getServiceName());
        Assertions.assertEquals(BigDecimal.valueOf(20.0), foundService.getServiceValue());
    }

    @Test
    @Transactional
    @Rollback
    public void testUpdateService() {
        // Arrange
        Service service = new Service();
        service.setServiceName("Air Filter Replacement");
        service.setServiceValue(BigDecimal.valueOf(15.0));
        Service savedService = serviceRepository.save(service);

        // Act
        savedService.setServiceValue(BigDecimal.valueOf(20.0));
        Service updatedService = serviceRepository.save(savedService);

        // Assert
        Assertions.assertEquals(savedService.getIdService(), updatedService.getIdService());
        Assertions.assertEquals(BigDecimal.valueOf(20.0), updatedService.getServiceValue());
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteService() {
        // Arrange
        Service service = new Service();
        service.setServiceName("Battery Replacement");
        service.setServiceValue(BigDecimal.valueOf(70.0));
        Service savedService = serviceRepository.save(service);

        // Act
        serviceRepository.delete(savedService);

        // Assert
        Assertions.assertFalse(serviceRepository.existsById(Math.toIntExact(savedService.getIdService())));
    }

}
