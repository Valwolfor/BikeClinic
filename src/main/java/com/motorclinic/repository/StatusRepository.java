package com.motorclinic.repository;

import com.motorclinic.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, Long> {

    Status findStatusById(Long id);
}
