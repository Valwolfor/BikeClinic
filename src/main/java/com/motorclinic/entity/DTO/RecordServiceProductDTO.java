package com.motorclinic.entity.DTO;

public class RecordServiceProductDTO {

    private Long id;
    private boolean isApproved;
    private ProductDTO product;
    private ServiceDTO service;
    private ServiceOrderDTO orderId;

    public RecordServiceProductDTO(){

    }

    public RecordServiceProductDTO(Long id, boolean isApproved, ProductDTO product, ServiceDTO service, ServiceOrderDTO orderId) {
        this.id = id;
        this.isApproved = isApproved;
        this.product = product;
        this.service = service;
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public ServiceDTO getService() {
        return service;
    }

    public void setService(ServiceDTO service) {
        this.service = service;
    }

    public ServiceOrderDTO getOrderId() {
        return orderId;
    }

    public void setOrderId(ServiceOrderDTO orderId) {
        this.orderId = orderId;
    }
}
