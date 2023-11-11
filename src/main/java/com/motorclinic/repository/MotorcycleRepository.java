package com.motorclinic.repository;

import com.motorclinic.entity.Customer;
import com.motorclinic.entity.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {

    @Query("SELECT m FROM Motorcycle m JOIN FETCH m.customer WHERE m.id = :id")
    Motorcycle getMotorcycleById(@Param("id") Long id);
    Motorcycle findByPlate (String plate);

    Motorcycle findByCustomer (Customer customer);
}
