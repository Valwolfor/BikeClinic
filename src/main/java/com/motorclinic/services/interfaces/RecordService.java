package com.motorclinic.services.interfaces;

import com.motorclinic.entity.*;
import com.motorclinic.entity.DTO.RecordServiceProductDTO;

import java.util.List;

public interface RecordService {
    RecordServiceProduct createRecord(RecordServiceProduct record);

    RecordServiceProduct updateRecord(RecordServiceProduct record);

    void deleteRecord(Long id);

    public RecordServiceProductDTO getRecordById(Long id);

    List<RecordServiceProduct> getRecordsByOrder(ServiceOrder order);

    List<RecordServiceProduct> getRecordByService(Service service);

    List<RecordServiceProduct> getByProduct(Product product);

    List<RecordServiceProduct> getByIsApprovedTrue();

    List<RecordServiceProduct> getByIsApprovedFalse();

    List<RecordServiceProduct> getAllRecords();
}
