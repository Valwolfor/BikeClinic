package com.motorclinic.services.interfaces;

import com.motorclinic.entity.Customer;
import com.motorclinic.entity.Motorcycle;

import java.util.List;

public interface MotorcycleService {

    Motorcycle createMotorcycle(Motorcycle motorcycle);
    Motorcycle updateMotorcycle(Motorcycle motorcycle);
    void deleteUMotorcycle(Long id);
    Motorcycle getMotorcycleById(Long id);
    Motorcycle getMotorcycleByOwner(Customer customer);
    Motorcycle getMotorcycleByPlate(String plate);
    List<Motorcycle> getAllMotorcycle();
}
