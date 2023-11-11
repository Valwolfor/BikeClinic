package com.motorclinic.services.implementations;

import com.motorclinic.entity.Customer;
import com.motorclinic.repository.CustomerRepository;
import com.motorclinic.services.interfaces.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer oldCustomer = repository.findById(customer.getId()).orElse(null);
        if (oldCustomer != null) {
            oldCustomer.setTypeId(customer.getTypeId());
            oldCustomer.setFirstName(customer.getFirstName());
            oldCustomer.setLastName(customer.getLastName());
            oldCustomer.setContactNumber(customer.getContactNumber());
            oldCustomer.setEmail(customer.getEmail());
        }

        if (oldCustomer == null) {
            throw new EntityNotFoundException("Registro de customer no encontrado con ID: " + customer.getId());
        }
        return repository.save(oldCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Customer getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }


}
