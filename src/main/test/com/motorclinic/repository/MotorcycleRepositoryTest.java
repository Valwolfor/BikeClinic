package com.motorclinic.repository;

import com.motorclinic.entity.Customer;
import com.motorclinic.entity.Motorcycle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MotorcycleRepositoryTest {

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @Transactional
    @Rollback
    public void testSaveMotorcycle() {
        // Arrange
        Customer customer = createCustomer();
        customerRepository.save(customer);

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setBrand("Honda");
        motorcycle.setChassisId("123456");
        motorcycle.setEngineId("789012");
        motorcycle.setModel("CBR");
        motorcycle.setPlate("XYZ123");
        motorcycle.setRegistrationYear("2022");
        motorcycle.setCustomer(customer);

        // Act
        Motorcycle savedMotorcycle = motorcycleRepository.save(motorcycle);

        // Assert
        Assertions.assertNotNull(savedMotorcycle.getId());
        Assertions.assertEquals("Honda", savedMotorcycle.getBrand());
        Assertions.assertEquals("123456", savedMotorcycle.getChassisId());
        Assertions.assertEquals("789012", savedMotorcycle.getEngineId());
        Assertions.assertEquals("CBR", savedMotorcycle.getModel());
        Assertions.assertEquals("XYZ123", savedMotorcycle.getPlate());
        Assertions.assertEquals("2022", savedMotorcycle.getRegistrationYear());
        Assertions.assertEquals(customer.getId(), savedMotorcycle.getCustomer().getId());
    }

    @Test
    @Transactional
    @Rollback
    public void testGetMotorcycleById() {
        // Arrange
        Motorcycle motorcycle = createMotorcycle();
        motorcycleRepository.save(motorcycle);

        // Act
        Motorcycle foundMotorcycle = motorcycleRepository.getMotorcycleById(motorcycle.getId());

        // Assert
        Assertions.assertNotNull(foundMotorcycle);
        Assertions.assertEquals(motorcycle.getId(), foundMotorcycle.getId());
        Assertions.assertEquals(motorcycle.getBrand(), foundMotorcycle.getBrand());
        Assertions.assertEquals(motorcycle.getChassisId(), foundMotorcycle.getChassisId());
        Assertions.assertEquals(motorcycle.getEngineId(), foundMotorcycle.getEngineId());
        Assertions.assertEquals(motorcycle.getModel(), foundMotorcycle.getModel());
        Assertions.assertEquals(motorcycle.getPlate(), foundMotorcycle.getPlate());
        Assertions.assertEquals(motorcycle.getRegistrationYear(), foundMotorcycle.getRegistrationYear());
        Assertions.assertEquals(motorcycle.getCustomer().getId(), foundMotorcycle.getCustomer().getId());
    }

    @Test
    @Transactional
    @Rollback
    public void testFindByPlate() {
        // Arrange
        Motorcycle motorcycle = createMotorcycle();
        motorcycleRepository.save(motorcycle);

        // Act
        Motorcycle foundMotorcycle = motorcycleRepository.findByPlate(motorcycle.getPlate());

        // Assert
        Assertions.assertNotNull(foundMotorcycle);
        Assertions.assertEquals(motorcycle.getId(), foundMotorcycle.getId());
        Assertions.assertEquals(motorcycle.getBrand(), foundMotorcycle.getBrand());
        Assertions.assertEquals(motorcycle.getChassisId(), foundMotorcycle.getChassisId());
        Assertions.assertEquals(motorcycle.getEngineId(), foundMotorcycle.getEngineId());
        Assertions.assertEquals(motorcycle.getModel(), foundMotorcycle.getModel());
        Assertions.assertEquals(motorcycle.getPlate(), foundMotorcycle.getPlate());
        Assertions.assertEquals(motorcycle.getRegistrationYear(), foundMotorcycle.getRegistrationYear());
        Assertions.assertEquals(motorcycle.getCustomer().getId(), foundMotorcycle.getCustomer().getId());
    }

    @Test
    @Transactional
    @Rollback
    public void testFindByCustomer() {
        // Arrange
        Motorcycle motorcycle = createMotorcycle();
        motorcycleRepository.save(motorcycle);

        // Act
        Motorcycle foundMotorcycle = motorcycleRepository.findByCustomer(motorcycle.getCustomer());

        // Assert
        Assertions.assertNotNull(foundMotorcycle);
        Assertions.assertEquals(motorcycle.getId(), foundMotorcycle.getId());
        Assertions.assertEquals(motorcycle.getBrand(), foundMotorcycle.getBrand());
        Assertions.assertEquals(motorcycle.getChassisId(), foundMotorcycle.getChassisId());
        Assertions.assertEquals(motorcycle.getEngineId(), foundMotorcycle.getEngineId());
        Assertions.assertEquals(motorcycle.getModel(), foundMotorcycle.getModel());
        Assertions.assertEquals(motorcycle.getPlate(), foundMotorcycle.getPlate());
        Assertions.assertEquals(motorcycle.getRegistrationYear(), foundMotorcycle.getRegistrationYear());
        Assertions.assertEquals(motorcycle.getCustomer().getId(), foundMotorcycle.getCustomer().getId());
    }

    @Test
    @Transactional
    @Rollback
    public void testUpdateMotorcycle() {
        // Arrange
        Motorcycle motorcycle = createMotorcycle();
        motorcycleRepository.save(motorcycle);

        // Act
        motorcycle.setBrand("UpdatedBrand");
        Motorcycle updatedMotorcycle = motorcycleRepository.save(motorcycle);

        // Assert
        Assertions.assertEquals(motorcycle.getId(), updatedMotorcycle.getId());
        Assertions.assertEquals("UpdatedBrand", updatedMotorcycle.getBrand());
        Assertions.assertEquals(motorcycle.getChassisId(), updatedMotorcycle.getChassisId());
        Assertions.assertEquals(motorcycle.getEngineId(), updatedMotorcycle.getEngineId());
        Assertions.assertEquals(motorcycle.getModel(), updatedMotorcycle.getModel());
        Assertions.assertEquals(motorcycle.getPlate(), updatedMotorcycle.getPlate());
        Assertions.assertEquals(motorcycle.getRegistrationYear(), updatedMotorcycle.getRegistrationYear());
        Assertions.assertEquals(motorcycle.getCustomer().getId(), updatedMotorcycle.getCustomer().getId());
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteMotorcycle() {
        // Arrange
        Motorcycle motorcycle = createMotorcycle();
        motorcycleRepository.save(motorcycle);

        // Act
        motorcycleRepository.delete(motorcycle);

        // Assert
        Assertions.assertFalse(motorcycleRepository.existsById(motorcycle.getId()));
    }

    private Motorcycle createMotorcycle() {
        Customer customer = createCustomer();
        customerRepository.save(customer);

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setBrand("Yamaha");
        motorcycle.setChassisId("654321");
        motorcycle.setEngineId("098765");
        motorcycle.setModel("YZF");
        motorcycle.setPlate("ABC123");
        motorcycle.setRegistrationYear("2023");
        motorcycle.setCustomer(customer);

        return motorcycle;
    }

    private Customer createCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Alice");
        customer.setLastName("Johnson");
        customer.setEmail("alice.johnson@example.com");
        customer.setContactNumber("456");
        return customer;
    }
}
