package Services.Interfaces;

import Beans.*;

import java.util.List;

public interface RecordService {
    RecordServiceProduct createRecord(RecordServiceProduct record);

    RecordServiceProduct updateRecord(RecordServiceProduct record);

    void deleteRecord(Long id);

    RecordServiceProduct getRecordById(Long id);

    List<RecordServiceProduct> getRecordsByOrder(ServiceOrder order);

    List<RecordServiceProduct> getRecordByService(Service service);

    List<RecordServiceProduct> getByProduct(Product product);

    List<RecordServiceProduct> getByIsApprovedTrue();

    List<RecordServiceProduct> getByIsApprovedFalse();

    List<RecordServiceProduct> getAllRecords();
}
