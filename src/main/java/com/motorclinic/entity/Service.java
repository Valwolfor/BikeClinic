package com.motorclinic.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idService;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "service_detail")
    private String serviceDetail;

    @Column(name = "service_value")
    private double serviceValue;

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDetail() {
        return serviceDetail;
    }

    public void setServiceDetail(String serviceDetail) {
        this.serviceDetail = serviceDetail;
    }

    public double getServiceValue() {
        return serviceValue;
    }

    public void setServiceValue(double serviceValue) {
        this.serviceValue = serviceValue;
    }

    @Override
    public String toString() {
        return "Service{" +
                "idService=" + idService +
                ", serviceName='" + serviceName + '\'' +
                ", serviceDetail='" + serviceDetail + '\'' +
                ", serviceValue=" + serviceValue +
                '}';
    }
}
