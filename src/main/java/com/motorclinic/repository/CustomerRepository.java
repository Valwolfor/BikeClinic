package com.motorclinic.repository;

import com.motorclinic.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String email);
}
