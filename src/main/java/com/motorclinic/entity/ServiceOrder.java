package com.motorclinic.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "service_order")
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private int orderId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @Column(name = "customer_name")
    private Integer customerId;

    @Column(name = "mechanic_name")
    private Integer mechanicId;

    @Column(name = "motorcycle_plate")
    private String motorcyclePlate;

    private String reason;

    @Column(name = "diagnostic_desc")
    private String diagnosticDescription;

    private String documents;

    private String advance;

    @Column(name = "advance_value")
    private double advanceValue;

    @Column(name = "route_auth")
    private String routeAuthorization;

    @OneToOne(mappedBy = "serviceOrder")
    private Status status;

    @OneToMany(mappedBy = "serviceOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecordServiceProduct> recordServiceProducts;
    public ServiceOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerName) {
        this.customerId = customerName;
    }

    public Integer getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(Integer mechanicName) {
        this.mechanicId = mechanicName;
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

    public String getDiagnosticDescription() {
        return diagnosticDescription;
    }

    public void setDiagnosticDescription(String diagnosticDescription) {
        this.diagnosticDescription = diagnosticDescription;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    public double getAdvanceValue() {
        return advanceValue;
    }

    public void setAdvanceValue(double advanceValue) {
        this.advanceValue = advanceValue;
    }

    public String getRouteAuthorization() {
        return routeAuthorization;
    }

    public void setRouteAuthorization(String routeAuthorization) {
        this.routeAuthorization = routeAuthorization;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<RecordServiceProduct> getRecordServiceProducts() {
        return recordServiceProducts;
    }

    public void setRecordServiceProducts(List<RecordServiceProduct> recordServiceProducts) {
        this.recordServiceProducts = recordServiceProducts;
    }

    @Override
    public String toString() {
        return "ServiceOrder{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", date=" + date +
                ", customerName='" + customerId + '\'' +
                ", mechanicName='" + mechanicId + '\'' +
                ", motorcyclePlate='" + motorcyclePlate + '\'' +
                ", reason='" + reason + '\'' +
                ", diagnosticDescription='" + diagnosticDescription + '\'' +
                ", documents='" + documents + '\'' +
                ", advance='" + advance + '\'' +
                ", advanceValue=" + advanceValue +
                ", routeAuthorization='" + routeAuthorization + '\'' +
                ", status=" + status.getId() +
                ", services and products=" + getRecordServiceProducts().toString() +
                '}';
    }

}
