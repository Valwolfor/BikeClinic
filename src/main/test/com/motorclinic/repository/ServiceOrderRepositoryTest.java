package com.motorclinic.repository;
import com.motorclinic.entity.*;
import com.motorclinic.entity.util.UserRole;
import com.motorclinic.entity.util.UserStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ServiceOrderRepositoryTest {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Test
    public void testFindByMotorcyclePlate() {
        // Arrange
        ServiceOrder serviceOrder1 = createServiceOrder("ABC123");

        // Act
        serviceOrderRepository.save(serviceOrder1);
        List<ServiceOrder> foundOrders = serviceOrderRepository.findByMotorcyclePlate("ABC123");

        // Assert
        assertEquals(1, foundOrders.size());
        assertEquals("ABC123", foundOrders.get(0).getMotorcyclePlate());
        assertEquals("AdvanceDesc", foundOrders.get(0).getAdvance());
        assertEquals(BigDecimal.valueOf(100.0), foundOrders.get(0).getAdvanceValue());
        assertEquals("DiagnosticDesc", foundOrders.get(0).getDiagnosticDesc());
        assertEquals("DocumentsDesc", foundOrders.get(0).getDocuments());
        assertEquals("ReasonDesc", foundOrders.get(0).getReason());
        assertTrue(foundOrders.get(0).isRouteAuth());

        // Assert Motorcycle details
        Motorcycle motorcycle = foundOrders.get(0).getMotorcycle();
        assertEquals("Brand", motorcycle.getBrand());
        assertEquals("Model", motorcycle.getModel());
        assertEquals("2022", motorcycle.getRegistrationYear());
        assertEquals("ABC123", motorcycle.getPlate());

        // Assert Status details
        Status status = foundOrders.get(0).getStatus();
        assertEquals("Good", status.getBrakeFluid());
        assertEquals("Good", status.getBrakes());
        // Assert other status properties

        // Assert Mechanic details
        User mechanic = foundOrders.get(0).getMechanic();
        assertEquals("John", mechanic.getFirstName());
        assertEquals("Doe", mechanic.getLastName());
        assertEquals("john.doe@example.com", mechanic.getEmail());
        assertEquals("1234567890", mechanic.getContactNumber());
        assertEquals("password", mechanic.getPassword());
        assertEquals(UserStatus.ACTIVE, mechanic.getStatus());
        assertEquals(Collections.singletonList(UserRole.MECHANIC), mechanic.getRoles());
    }

    @Test
    public void testFindByDate() {
        // Arrange
        LocalDateTime targetDate = LocalDateTime.now();
        ServiceOrder serviceOrder1 = createServiceOrderWithDate(targetDate, "ABC123");
        ServiceOrder serviceOrder2 = createServiceOrderWithDate(targetDate, "ABC456");

        // Act
        serviceOrderRepository.save(serviceOrder1);
        serviceOrderRepository.save(serviceOrder2);

        List<ServiceOrder> foundOrders = serviceOrderRepository.findByDate(targetDate);

        // Assert
        assertEquals(1, foundOrders.size());
        assertEquals(targetDate, foundOrders.get(0).getDate());
    }

    @Test
    public void testFindByDateBetween() {
        // Arrange
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = startDate.plusDays(5);
        ServiceOrder serviceOrder1 = createServiceOrderWithDate(startDate.plusDays(2), "FSE456");
        ServiceOrder serviceOrder2 = createServiceOrderWithDate(endDate.plusDays(1), "ASD436");

        // Act
        serviceOrderRepository.save(serviceOrder1);
        serviceOrderRepository.save(serviceOrder2);

        List<ServiceOrder> foundOrders = serviceOrderRepository.findByDateBetween(startDate, endDate);

        // Assert
        assertEquals(2, foundOrders.size());
    }

    private Status createStatus() {
        Status status = new Status();
        status.setBrakeFluid("Good");
        status.setBrakes("Good");
        status.setChain("Good");
        status.setChassis("Good");
        status.setClutch("Good");
        status.setClutchFluid("Good");
        status.setCoolant("Good");
        status.setEngine("Good");
        status.setExhaust("Good");
        status.setFootPegs("Good");
        status.setFrontTire("Good");
        status.setFuel("Good");
        status.setHorn("Good");
        status.setIndicators("Good");
        status.setIndicatorsDesc("Good");
        status.setLightsGood("Good");
        status.setMileage("Good");
        status.setMirrors("Good");
        status.setOil("Good");
        status.setOilLevel("Good");
        status.setRearTire("Good");
        status.setTank("Good");
        status.setThrottle("Good");
        status.setTransmission("Good");
        return status;
    }

    private Motorcycle createMotorcycle() {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setBrand("Honda");
        motorcycle.setChassisId("CH123456");
        motorcycle.setEngineId("EN789012");
        motorcycle.setModel("CBR500R");
        motorcycle.setPlate("ABC123");
        motorcycle.setRegistrationYear("2022");

        Customer customer = createCustomer();
        motorcycle.setCustomer(customer);

        return motorcycle;
    }

    private Customer createCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@example.com");
        customer.setContactNumber("1234567890");
        return customer;
    }

    private ServiceOrder createServiceOrderWithDate(LocalDateTime date, String plate){
        ServiceOrder newService = createServiceOrder(plate);
        newService.setDate(date);
        return newService;
    }
    private ServiceOrder createServiceOrder(String motorcyclePlate) {
        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setAdvance("AdvanceDesc");
        serviceOrder.setAdvanceValue(BigDecimal.valueOf(100.0));
        serviceOrder.setDate(LocalDateTime.now());
        serviceOrder.setDiagnosticDesc("DiagnosticDesc");
        serviceOrder.setDocuments("DocumentsDesc");
        serviceOrder.setMotorcyclePlate(motorcyclePlate);
        serviceOrder.setReason("ReasonDesc");
        serviceOrder.setRouteAuth(true);

        Motorcycle motorcycle = createMotorcycle();
        serviceOrder.setMotorcycle(motorcycle);

        Status status = createStatus();
        serviceOrder.setStatus(status);

        User mechanic = new User();
        mechanic.setFirstName("John");
        mechanic.setLastName("Doe");
        mechanic.setEmail("john.doe@example.com");
        mechanic.setContactNumber("1234567890");
        mechanic.setPassword("password");
        mechanic.setStatus(UserStatus.ACTIVE);
        mechanic.setRoles(Collections.singletonList(UserRole.MECHANIC));

        serviceOrder.setMechanic(mechanic);

        return serviceOrder;
    }
}
