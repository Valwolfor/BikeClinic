//package com.motorclinic.repository;
//
//import com.motorclinic.entity.Status;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface StatusRepository extends JpaRepository<Status, Long> {
//    @Query("SELECT s FROM Status s")
//    List<Status> findAllStatus();
//
//    // Recuperar un estado por ID
//    @Query("SELECT s FROM Status s WHERE s.id = :id")
//    Status findStatusById(Long id);
//    Status findByMotorcycleId (Long id);
//}
