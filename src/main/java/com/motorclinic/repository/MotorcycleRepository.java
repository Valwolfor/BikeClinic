package com.motorclinic.repository;

import com.motorclinic.entity.Customer;
import com.motorclinic.entity.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {

    Motorcycle findByPlate (String plate);

    Motorcycle findByCustomer (Customer customer);
}
