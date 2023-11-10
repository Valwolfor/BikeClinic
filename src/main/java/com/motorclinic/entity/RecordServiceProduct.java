package com.motorclinic.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "record_serv_prod")
public class RecordServiceProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private ServiceOrder serviceOrder;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Additional fields specific to the relationship
    @Column(name = "is_approved")
    private Boolean isApproved;

    public RecordServiceProduct() {
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceOrder getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    @Override
    public String toString() {
        return "RecordServiceProduct{" +
                "id=" + id +
                ", order=" + serviceOrder +
                ", service=" + service +
                ", product=" + product +
                ", isApproved=" + isApproved +
                '}';
    }
}
