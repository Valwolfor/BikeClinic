package com.motorclinic.entity.DTO;

import java.math.BigDecimal;

public class ServiceDTO {

    private Long idService;
    private String serviceName;
    private String serviceDetail;
    private BigDecimal serviceValue;

    public ServiceDTO(){

    }
    public ServiceDTO(Long idService, String serviceName, String serviceDetail, BigDecimal serviceValue) {
        this.idService = idService;
        this.serviceName = serviceName;
        this.serviceDetail = serviceDetail;
        this.serviceValue = serviceValue;
    }

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
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

    public BigDecimal getServiceValue() {
        return serviceValue;
    }

    public void setServiceValue(BigDecimal serviceValue) {
        this.serviceValue = serviceValue;
    }
}
