package com.motorclinic.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_order")
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "advance", nullable = false)
    private String advance;

    @Column(name = "advance_value")
    private BigDecimal advanceValue;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "diagnostic_desc")
    private String diagnosticDesc;

    @Column(name = "documents", nullable = false)
    private String documents;

    @Column(name = "motorcycle_plate", nullable = false)
    private String motorcyclePlate;

    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "route_auth", nullable = false)
    private boolean routeAuth;

    @ManyToOne
    @JoinColumn(name = "motorcycle_id", nullable = false)
    private Motorcycle motorcycle;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id_mech", nullable = false)
    private User mechanic;

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

    public boolean isRouteAuth() {
        return routeAuth;
    }

    public void setRouteAuth(boolean routeAuth) {
        this.routeAuth = routeAuth;
    }

    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getMechanic() {
        return mechanic;
    }

    public void setMechanic(User mechanic) {
        this.mechanic = mechanic;
    }

    @Override
    public String toString() {
        return "ServiceOrder{" +
                "id=" + id +
                ", advance='" + advance + '\'' +
                ", advanceValue=" + advanceValue +
                ", date=" + date +
                ", diagnosticDesc='" + diagnosticDesc + '\'' +
                ", documents='" + documents + '\'' +
                ", motorcyclePlate='" + motorcyclePlate + '\'' +
                ", reason='" + reason + '\'' +
                ", routeAuth=" + routeAuth +
                ", motorcycle=" + motorcycle +
                ", status=" + status +
                ", mechanic=" + mechanic +
                '}';
    }
}
