package com.motorclinic.repository;

import com.motorclinic.entity.Product;
import com.motorclinic.entity.RecordServiceProduct;
import com.motorclinic.entity.Service;
import com.motorclinic.entity.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecordRepository extends JpaRepository<RecordServiceProduct, Long> {

    List<RecordServiceProduct> findByOrder(ServiceOrder serviceOrder);

    List<RecordServiceProduct> findByService(Service service);

    List<RecordServiceProduct> findByProduct(Product product);

    List<RecordServiceProduct> findByIsApprovedTrue();

    List<RecordServiceProduct> findByIsApprovedFalse();
}

