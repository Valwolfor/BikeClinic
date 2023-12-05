package com.motorclinic.repository;

import com.motorclinic.entity.util.UserRole;
import com.motorclinic.entity.util.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.motorclinic.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class RecordRepositoryTest {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    @Autowired
    private UserRepository mechanicRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Test
    @Transactional
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testCrudOperations() {
        // Create
        ServiceOrder serviceOrder = createServiceOrder("ABC123");
        serviceOrder = serviceOrderRepository.save(serviceOrder);

        Product product = createProduct("Brake Fluid");
        product = productRepository.save(product);

        Service service = createService("Oil Change");
        service = serviceRepository.save(service);

        RecordServiceProduct record = createRecord(serviceOrder, product, service);
       recordRepository.save(record);

        // Read
        RecordServiceProduct foundRecord = recordRepository.findById(record.getId()).orElse(null);
        assertNotNull(foundRecord);
        assertEquals(record.isApproved(), foundRecord.isApproved());
        assertEquals(record.getProduct(), foundRecord.getProduct());
        assertEquals(record.getService(), foundRecord.getService());
        assertEquals(record.getOrder(), foundRecord.getOrder());

        // Update
        foundRecord.setApproved(true);
        recordRepository.save(foundRecord);

        RecordServiceProduct updatedRecord = recordRepository.findById(foundRecord.getId()).orElse(null);
        assertNotNull(updatedRecord);
        assertTrue(updatedRecord.isApproved());

        // Delete
        recordRepository.deleteById(updatedRecord.getId());
        RecordServiceProduct deletedRecord = recordRepository.findById(updatedRecord.getId()).orElse(null);
        assertNull(deletedRecord);
    }
    private Product createProduct(String name) {
        Product product = new Product();
        product.setProductName(name);
        product.setProductName("Aceíte");
        product.setProductValue(BigDecimal.valueOf(19.0));
        product.setQuantity(10);
        return product;
    }

    private Service createService(String name) {
        Service service = new Service();
        service.setServiceName(name);
        service.setServiceValue(BigDecimal.valueOf(19.0));
        service.setServiceDetail("Cosas");
        return service;
    }

    private RecordServiceProduct createRecord(ServiceOrder order, Product product, Service service) {
        RecordServiceProduct record = new RecordServiceProduct();
        record.setOrder(order);
        record.setProduct(product);
        record.setService(service);
        record.setApproved(false);
        return record;
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

    private ServiceOrder createServiceOrder(String motorcyclePlate) {
        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setAdvance("AdvanceDesc");
        serviceOrder.setAdvanceValue(BigDecimal.valueOf(100.0));
        serviceOrder.setDate(LocalDate.now());
        serviceOrder.setDiagnosticDesc("DiagnosticDesc");
        serviceOrder.setDocuments("DocumentsDesc");
        serviceOrder.setMotorcyclePlate(motorcyclePlate);
        serviceOrder.setReason("ReasonDesc");
        serviceOrder.setRouteAuth(true);

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@noexample.com");
        customer.setContactNumber("1234567890");
        customerRepository.save(customer);

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setBrand("Honda");
        motorcycle.setChassisId("CH123456");
        motorcycle.setEngineId("EN789012");
        motorcycle.setModel("CBR500R");
        motorcycle.setPlate("ABC123");
        motorcycle.setRegistrationYear("2022");
        motorcycle.setCustomer(customer);

        motorcycleRepository.save(motorcycle);
        serviceOrder.setMotorcycle(motorcycle);

        Status status = createStatus();
        statusRepository.save(status);
        serviceOrder.setStatus(status);

        User mechanic = new User();
        mechanic.setFirstName("John");
        mechanic.setLastName("Doe");
        mechanic.setEmail("john.doe@example.com");
        mechanic.setContactNumber("1234567890");
        mechanic.setPassword("password");
        mechanic.setStatus(UserStatus.ACTIVE);
        mechanic.setRoles(Collections.singletonList(UserRole.MECHANIC));

        mechanicRepository.save(mechanic);

        serviceOrder.setMechanic(mechanic);

        return serviceOrder;
    }
}