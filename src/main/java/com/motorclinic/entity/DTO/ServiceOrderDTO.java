package com.motorclinic.entity.DTO;

import com.motorclinic.entity.ServiceOrder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ServiceOrderDTO {
    private Long id;
    private String advance;
    private BigDecimal advanceValue;
    private LocalDateTime date;
    private String diagnosticDesc;
    private String documents;
    private String motorcyclePlate;
    private String reason;
    private Boolean routeAuth;
    private Long motorcycleId;
    private Long statusId;
    private Long mechanicId;

    // Constructor, getters y setters

    public ServiceOrderDTO() {
    }

    public ServiceOrderDTO(ServiceOrder serviceOrder) {
        this.id = serviceOrder.getId();
        this.advance = serviceOrder.getAdvance();
        this.advanceValue = serviceOrder.getAdvanceValue();
        this.date = serviceOrder.getDate();
        this.diagnosticDesc = serviceOrder.getDiagnosticDesc();
        this.documents = serviceOrder.getDocuments();
        this.motorcyclePlate = serviceOrder.getMotorcyclePlate();
        this.reason = serviceOrder.getReason();
        this.routeAuth = serviceOrder.isRouteAuth();
        this.motorcycleId = serviceOrder.getMotorcycle().getId();
        this.statusId = serviceOrder.getStatus().getId();
        this.mechanicId = serviceOrder.getMechanic().getId();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    public BigDecimal getAdvanceValue() {
        return advanceValue;
    }

    public void setAdvanceValue(BigDecimal advanceValue) {
        this.advanceValue = advanceValue;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDiagnosticDesc() {
        return diagnosticDesc;
    }

    public void setDiagnosticDesc(String diagnosticDesc) {
        this.diagnosticDesc = diagnosticDesc;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getMotorcyclePlate() {
        return motorcyclePlate;
    }

    public void setMotorcyclePlate(String motorcyclePlate) {
        this.motorcyclePlate = motorcyclePlate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getRouteAuth() {
        return routeAuth;
    }

    public void setRouteAuth(Boolean routeAuth) {
        this.routeAuth = routeAuth;
    }

    public Long getMotorcycleId() {
        return motorcycleId;
    }

    public void setMotorcycleId(Long motorcycleId) {
        this.motorcycleId = motorcycleId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(Long mechanicId) {
        this.mechanicId = mechanicId;
    }
}
