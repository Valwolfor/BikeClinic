package com.motorclinic.repository;

import com.motorclinic.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @Transactional
    @Rollback
    public void testSaveCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@example.com");
        customer.setContactNumber("123");

        // Act
        Customer savedCustomer = customerRepository.save(customer);

        // Assert
        Assertions.assertNotNull(savedCustomer.getId());
        Assertions.assertEquals("John", savedCustomer.getFirstName());
        Assertions.assertEquals("Doe", savedCustomer.getLastName());
        Assertions.assertEquals("john.doe@example.com", savedCustomer.getEmail());
        Assertions.assertEquals("123", savedCustomer.getContactNumber());
    }

    @Test
    @Transactional
    @Rollback
    public void testFindCustomerById() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Jane");
        customer.setLastName("Smith");
        customer.setEmail("jane.smith@example.com");
        customer.setContactNumber("123");
        Customer savedCustomer = customerRepository.save(customer);

        // Act
        Optional<Customer> foundCustomerOptional = customerRepository.findById(savedCustomer.getId());

        // Assert
        Assertions.assertTrue(foundCustomerOptional.isPresent());
        Customer foundCustomer = foundCustomerOptional.get();
        Assertions.assertEquals("Jane", foundCustomer.getFirstName());
        Assertions.assertEquals("Smith", foundCustomer.getLastName());
        Assertions.assertEquals("jane.smith@example.com", foundCustomer.getEmail());
        Assertions.assertEquals("123", savedCustomer.getContactNumber());
    }

    @Test
    @Transactional
    @Rollback
    public void testUpdateCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Mark");
        customer.setLastName("Johnson");
        customer.setEmail("mark.johnson@example.com");
        customer.setContactNumber("123");
        Customer savedCustomer = customerRepository.save(customer);

        // Act
        savedCustomer.setFirstName("UpdatedMark");
        Customer updatedCustomer = customerRepository.save(savedCustomer);

        // Assert
        Assertions.assertEquals(savedCustomer.getId(), updatedCustomer.getId());
        Assertions.assertEquals("UpdatedMark", updatedCustomer.getFirstName());
        Assertions.assertEquals("Johnson", updatedCustomer.getLastName());
        Assertions.assertEquals("mark.johnson@example.com", updatedCustomer.getEmail());
        Assertions.assertEquals("123", savedCustomer.getContactNumber());
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Alice");
        customer.setLastName("Jones");
        customer.setEmail("alice.jones@example.com");
        customer.setContactNumber("123");
        Customer savedCustomer = customerRepository.save(customer);

        // Act
        customerRepository.delete(savedCustomer);

        // Assert
        Assertions.assertFalse(customerRepository.existsById(savedCustomer.getId()));
    }
}
