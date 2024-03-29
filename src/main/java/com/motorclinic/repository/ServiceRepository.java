package com.motorclinic.repository;

import com.motorclinic.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query("SELECT s FROM Service s WHERE s.idService = :id")
    Service findServiceById(@Param("id") Long id);
    @Query("SELECT s FROM Service s WHERE s.serviceName = :name")
    Service findSeviceByName (@Param("name") String name);
}
