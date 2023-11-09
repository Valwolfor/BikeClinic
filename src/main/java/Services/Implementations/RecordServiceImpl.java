package Services.Implementations;

import Beans.Product;
import Beans.RecordServiceProduct;
import Beans.ServiceOrder;
import Repository.RecordRepository;
import Services.Interfaces.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RecordServiceImpl implements RecordService {

    private final RecordRepository repository;

    @Autowired
    public RecordServiceImpl(RecordRepository recordRepository) {
        this.repository = recordRepository;
    }


    @Override
    public RecordServiceProduct createRecord(RecordServiceProduct record) {
        return repository.save(record);
    }

    @Override
    public RecordServiceProduct updateRecord(RecordServiceProduct record) {
        RecordServiceProduct oldRecord = repository.findById(record.getId()).orElse(null);
        if (oldRecord != null) {
            oldRecord.setService(record.getService());
            oldRecord.setProduct(record.getProduct());
            oldRecord.setOrder(record.getOrder());
            oldRecord.setIsApproved(record.getIsApproved());
        }
        assert oldRecord != null;
        return repository.save(record);
    }

    @Override
    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }

    @Override
    public RecordServiceProduct getRecordById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<RecordServiceProduct> getRecordsByOrder(ServiceOrder order) {
        return repository.findByOrder(order);
    }

    @Override
    public List<RecordServiceProduct> getRecordByService(Beans.Service service) {
        return repository.findByService(service);
    }

    @Override
    public List<RecordServiceProduct> getByProduct(Product product) {
        return repository.findByProduct(product);
    }

    @Override
    public List<RecordServiceProduct> getByIsApprovedTrue() {
        return repository.findByIsApprovedTrue();
    }

    @Override
    public List<RecordServiceProduct> getByIsApprovedFalse() {
        return repository.findByIsApprovedFalse();
    }

    @Override
    public List<RecordServiceProduct> getAllRecords() {
        return repository.findAll();
    }
}
