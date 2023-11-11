//package com.motorclinic.repository;
//
//import com.motorclinic.entity.ServiceOrder;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.Date;
//import java.util.List;
//
//public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
//    @Query("SELECT so FROM ServiceOrder so LEFT JOIN FETCH so. WHERE so.id = :id")
//    ServiceOrder findByIdWithRecordServiceProducts(@Param("id") Long id);
//    ServiceOrder findByDate(Date date);
//    ServiceOrder findByDateBetween(Date start, Date end);
//    @Query("SELECT so FROM ServiceOrder so WHERE so.mechanic = :mechanicId")
//    List<ServiceOrder> findByMchanicId(@Param("mechanicId") Integer mechanicId);
//
//    List<ServiceOrder> findByMotorcyclePlate (String plate);
//
//}
