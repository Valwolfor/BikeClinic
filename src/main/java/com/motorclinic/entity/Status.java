package com.motorclinic.entity;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brake_fluid", nullable = false)
    private String brakeFluid;

    @Column(name = "brakes", nullable = false)
    private String brakes;

    @Column(name = "chain", nullable = false)
    private String chain;

    @Column(name = "chassis", nullable = false)
    private String chassis;

    @Column(name = "clutch", nullable = false)
    private String clutch;

    @Column(name = "clutch_fluid", nullable = false)
    private String clutchFluid;

    @Column(name = "coolant", nullable = false)
    private String coolant;

    @Column(name = "engine", nullable = false)
    private String engine;

    @Column(name = "exhaust", nullable = false)
    private String exhaust;

    @Column(name = "foot_pegs", nullable = false)
    private String footPegs;

    @Column(name = "front_tire", nullable = false)
    private String frontTire;

    @Column(name = "fuel", nullable = false)
    private String fuel;

    @Column(name = "horn", nullable = false)
    private String horn;

    @Column(name = "indicators", nullable = false)
    private String indicators;

    @Column(name = "indicators_desc", nullable = false)
    private String indicatorsDesc;

    //TODO arreglar lo del registro de varios con mejor método.
    @Column(name = "lights_good", nullable = false)
    private String lightsGood;

    @Column(name = "mileage", nullable = false)
    private String mileage;

    @Column(name = "mirrors", nullable = false)
    private String mirrors;

    @Column(name = "oil", nullable = false)
    private String oil;

    @Column(name = "oil_level", nullable = false)
    private String oilLevel;

    @Column(name = "rear_tire", nullable = false)
    private String rearTire;

    @Column(name = "tank", nullable = false)
    private String tank;

    @Column(name = "throttle", nullable = false)
    private String throttle;

    @Column(name = "transmission", nullable = false)
    private String transmission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrakeFluid() {
        return brakeFluid;
    }

    public void setBrakeFluid(String brakeFluid) {
        this.brakeFluid = brakeFluid;
    }

    public String getBrakes() {
        return brakes;
    }

    public void setBrakes(String brakes) {
        this.brakes = brakes;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getClutch() {
        return clutch;
    }

    public void setClutch(String clutch) {
        this.clutch = clutch;
    }

    public String getClutchFluid() {
        return clutchFluid;
    }

    public void setClutchFluid(String clutchFluid) {
        this.clutchFluid = clutchFluid;
    }

    public String getCoolant() {
        return coolant;
    }

    public void setCoolant(String coolant) {
        this.coolant = coolant;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getExhaust() {
        return exhaust;
    }

    public void setExhaust(String exhaust) {
        this.exhaust = exhaust;
    }

    public String getFootPegs() {
        return footPegs;
    }

    public void setFootPegs(String footPegs) {
        this.footPegs = footPegs;
    }

    public String getFrontTire() {
        return frontTire;
    }

    public void setFrontTire(String frontTire) {
        this.frontTire = frontTire;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getHorn() {
        return horn;
    }

    public void setHorn(String horn) {
        this.horn = horn;
    }

    public String getIndicators() {
        return indicators;
    }

    public void setIndicators(String indicators) {
        this.indicators = indicators;
    }

    public String getIndicatorsDesc() {
        return indicatorsDesc;
    }

    public void setIndicatorsDesc(String indicatorsDesc) {
        this.indicatorsDesc = indicatorsDesc;
    }

    public void setLightsGood(String lightsGood) {
        this.lightsGood = lightsGood;
    }

    public String getLightsGood() {
        return lightsGood;
    }
    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getMirrors() {
        return mirrors;
    }

    public void setMirrors(String mirrors) {
        this.mirrors = mirrors;
    }

    public String getOil() {
        return oil;
    }

    public void setOil(String oil) {
        this.oil = oil;
    }

    public String getOilLevel() {
        return oilLevel;
    }

    public void setOilLevel(String oilLevel) {
        this.oilLevel = oilLevel;
    }

    public String getRearTire() {
        return rearTire;
    }

    public void setRearTire(String rearTire) {
        this.rearTire = rearTire;
    }

    public String getTank() {
        return tank;
    }

    public void setTank(String tank) {
        this.tank = tank;
    }

    public String getThrottle() {
        return throttle;
    }

    public void setThrottle(String throttle) {
        this.throttle = throttle;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", brakeFluid='" + brakeFluid + '\'' +
                ", brakes='" + brakes + '\'' +
                ", chain='" + chain + '\'' +
                ", chassis='" + chassis + '\'' +
                ", clutch='" + clutch + '\'' +
                ", clutchFluid='" + clutchFluid + '\'' +
                ", coolant='" + coolant + '\'' +
                ", engine='" + engine + '\'' +
                ", exhaust='" + exhaust + '\'' +
                ", footPegs='" + footPegs + '\'' +
                ", frontTire='" + frontTire + '\'' +
                ", fuel='" + fuel + '\'' +
                ", horn='" + horn + '\'' +
                ", indicators='" + indicators + '\'' +
                ", indicatorsDesc='" + indicatorsDesc + '\'' +
                ", lightsGood='" + lightsGood + '\'' +
                ", mileage='" + mileage + '\'' +
                ", mirrors='" + mirrors + '\'' +
                ", oil='" + oil + '\'' +
                ", oilLevel='" + oilLevel + '\'' +
                ", rearTire='" + rearTire + '\'' +
                ", tank='" + tank + '\'' +
                ", throttle='" + throttle + '\'' +
                ", transmission='" + transmission + '\'' +
                '}';
    }
}
