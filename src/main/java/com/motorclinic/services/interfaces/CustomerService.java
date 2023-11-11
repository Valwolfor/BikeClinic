package com.motorclinic.services.interfaces;

import com.motorclinic.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long id);

    Customer getCustomerById(Long id);

    Customer getByEmail(String email);

    List<Customer> getAllCustomers();
}
