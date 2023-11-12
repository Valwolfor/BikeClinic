package com.motorclinic.services.implementations;

import com.motorclinic.entity.DTO.ProductDTO;
import com.motorclinic.entity.DTO.RecordServiceProductDTO;
import com.motorclinic.entity.DTO.ServiceDTO;
import com.motorclinic.entity.DTO.ServiceOrderDTO;
import com.motorclinic.entity.Product;
import com.motorclinic.entity.RecordServiceProduct;
import com.motorclinic.entity.Service;
import com.motorclinic.entity.ServiceOrder;
import com.motorclinic.repository.RecordRepository;
import com.motorclinic.services.interfaces.RecordService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
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
            oldRecord.setApproved(record.isApproved());
        }

        if (oldRecord == null) {
            throw new EntityNotFoundException("Registro de servicio no encontrado con ID: " + record.getId());
        }
        return repository.save(record);
    }

    @Override
    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }

    @Override
    public RecordServiceProductDTO getRecordById(Long id) {
        RecordServiceProduct recordServiceProduct = repository.getReferenceById(id);

        if (recordServiceProduct == null) {
            throw new EntityNotFoundException("RecordServiceProduct not found with ID: " + id);
        }

        // Mapear la entidad a un DTO
        return mapRecordServiceProductToDTO(recordServiceProduct);
    }

    @Override
    public List<RecordServiceProduct> getRecordsByOrder(ServiceOrder order) {
        return repository.findByOrder(order);
    }

    @Override
    public List<RecordServiceProduct> getRecordByService(com.motorclinic.entity.Service service) {
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

    private RecordServiceProductDTO mapRecordServiceProductToDTO(RecordServiceProduct recordServiceProduct) {
        RecordServiceProductDTO dto = new RecordServiceProductDTO();
        dto.setId(recordServiceProduct.getId());
        dto.setApproved(recordServiceProduct.isApproved());

        // Mapear ProductDTO, ServiceDTO y ServiceOrderDTO
        dto.setProduct(mapProductToDTO(recordServiceProduct.getProduct()));
        dto.setService(mapServiceToDTO(recordServiceProduct.getService()));
        dto.setOrderId(mapServiceOrderToDTO(recordServiceProduct.getOrder()));

        return dto;
    }

    private ProductDTO mapProductToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdProduct(product.getIdProduct());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductValue(product.getProductValue());
        productDTO.setQuantity(product.getQuantity());
        return productDTO;
    }

    private ServiceDTO mapServiceToDTO(Service service) {
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setIdService(service.getIdService());
        serviceDTO.setServiceName(service.getServiceName());
        serviceDTO.setServiceDetail(service.getServiceDetail());
        serviceDTO.setServiceValue(service.getServiceValue());
        return serviceDTO;
    }

    private ServiceOrderDTO mapServiceOrderToDTO(ServiceOrder serviceOrder) {
        ServiceOrderDTO serviceOrderDTO = new ServiceOrderDTO();

        serviceOrderDTO.setId(serviceOrder.getId());
        serviceOrderDTO.setAdvance(serviceOrder.getAdvance());
        serviceOrderDTO.setAdvanceValue(serviceOrder.getAdvanceValue());
        serviceOrderDTO.setDate(serviceOrder.getDate());
        serviceOrderDTO.setDiagnosticDesc(serviceOrder.getDiagnosticDesc());
        serviceOrderDTO.setDocuments(serviceOrder.getDocuments());
        serviceOrderDTO.setMotorcyclePlate(serviceOrder.getMotorcyclePlate());
        serviceOrderDTO.setReason(serviceOrder.getReason());
        serviceOrderDTO.setRouteAuth(serviceOrder.isRouteAuth());
        serviceOrderDTO.setMotorcycleId(serviceOrder.getMotorcycle().getId());
        serviceOrderDTO.setStatusId(serviceOrder.getStatus().getId());
        serviceOrderDTO.setMechanicId(serviceOrder.getMechanic().getId());

        return serviceOrderDTO;
    }
}
