package com.motorclinic.repository;

import com.motorclinic.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByMotorcycleId (Long id);
}