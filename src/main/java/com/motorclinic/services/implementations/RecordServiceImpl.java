//package com.motorclinic.services.implementations;
//
//import com.motorclinic.entity.Product;
//import com.motorclinic.entity.RecordServiceProduct;
//import com.motorclinic.entity.ServiceOrder;
//import com.motorclinic.repository.RecordRepository;
//import com.motorclinic.services.interfaces.RecordService;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@Transactional
//public class RecordServiceImpl implements RecordService {
//
//    private final RecordRepository repository;
//
//    @Autowired
//    public RecordServiceImpl(RecordRepository recordRepository) {
//        this.repository = recordRepository;
//    }
//
//
//    @Override
//    public RecordServiceProduct createRecord(RecordServiceProduct record) {
//        return repository.save(record);
//    }
//
//    @Override
//    public RecordServiceProduct updateRecord(RecordServiceProduct record) {
//        RecordServiceProduct oldRecord = repository.findById(record.getId()).orElse(null);
//        if (oldRecord != null) {
//            oldRecord.setService(record.getService());
//            oldRecord.setProduct(record.getProduct());
//            oldRecord.setServiceOrder(record.getServiceOrder());
//            oldRecord.setIsApproved(record.getIsApproved());
//        }
//
//        if (oldRecord == null) {
//            throw new EntityNotFoundException("Registro de servicio no encontrado con ID: " + record.getId());
//        }
//        return repository.save(record);
//    }
//
//    @Override
//    public void deleteRecord(Long id) {
//        repository.deleteById(id);
//    }
//
//    @Override
//    public RecordServiceProduct getRecordById(Long id) {
//        return repository.getReferenceById(id);
//    }
//
//    @Override
//    public List<RecordServiceProduct> getRecordsByOrder(ServiceOrder order) {
//        return repository.findByServiceOrden(order);
//    }
//
//    @Override
//    public List<RecordServiceProduct> getRecordByService(com.motorclinic.entity.Service service) {
//        return repository.findByService(service);
//    }
//
//    @Override
//    public List<RecordServiceProduct> getByProduct(Product product) {
//        return repository.findByProduct(product);
//    }
//
//    @Override
//    public List<RecordServiceProduct> getByIsApprovedTrue() {
//        return repository.findByIsApprovedTrue();
//    }
//
//    @Override
//    public List<RecordServiceProduct> getByIsApprovedFalse() {
//        return repository.findByIsApprovedFalse();
//    }
//
//    @Override
//    public List<RecordServiceProduct> getAllRecords() {
//        return repository.findAll();
//    }
//}
