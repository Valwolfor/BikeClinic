package Beans;

import jakarta.persistence.*;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "motorcycle_id")
    private Long motorcycleId;

    private String indicators;
    @Column(name = "indicators_desc")
    private String indicatorsDescription;
    private String oil;
    @Column(name = "oil_level")
    private String oilLevel;
    @Column(name = "brake_fluid")
    private String brakeFluid;
    @Column(name = "clutch_fluid")
    private String clutchFluid;
    private String coolant;
    @Column(name = "lights_good")
    private String lightsGood;
    private String mirrors;
    private String horn;
    private String tank;
    @Column(name = "front_tire")
    private String frontTire;
    @Column(name = "rear_tire")
    private String rearTire;
    private String engine;
    private String chassis;
    private String throttle;
    private String exhaust;
    private String transmission;
    private String clutch;
    private String brakes;
    private String chain;
    @Column(name = "foot_pegs")
    private String footPegs;
    private String mileage;
    private String fuel;

    public Status() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMotorcycleId() {
        return motorcycleId;
    }

    public void setMotorcycleId(Long motorcycleId) {
        this.motorcycleId = motorcycleId;
    }

    public String getIndicators() {
        return indicators;
    }

    public void setIndicators(String indicators) {
        this.indicators = indicators;
    }

    public String getIndicatorsDescription() {
        return indicatorsDescription;
    }

    public void setIndicatorsDescription(String indicatorsDescription) {
        this.indicatorsDescription = indicatorsDescription;
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

    public String getBrakeFluid() {
        return brakeFluid;
    }

    public void setBrakeFluid(String brakeFluid) {
        this.brakeFluid = brakeFluid;
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

    public String getLightsGood() {
        return lightsGood;
    }

    public void setLightsGood(String lightsGood) {
        this.lightsGood = lightsGood;
    }

    public String getMirrors() {
        return mirrors;
    }

    public void setMirrors(String mirrors) {
        this.mirrors = mirrors;
    }

    public String getHorn() {
        return horn;
    }

    public void setHorn(String horn) {
        this.horn = horn;
    }

    public String getTank() {
        return tank;
    }

    public void setTank(String tank) {
        this.tank = tank;
    }

    public String getFrontTire() {
        return frontTire;
    }

    public void setFrontTire(String frontTire) {
        this.frontTire = frontTire;
    }

    public String getRearTire() {
        return rearTire;
    }

    public void setRearTire(String rearTire) {
        this.rearTire = rearTire;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getThrottle() {
        return throttle;
    }

    public void setThrottle(String throttle) {
        this.throttle = throttle;
    }

    public String getExhaust() {
        return exhaust;
    }

    public void setExhaust(String exhaust) {
        this.exhaust = exhaust;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getClutch() {
        return clutch;
    }

    public void setClutch(String clutch) {
        this.clutch = clutch;
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

    public String getFootPegs() {
        return footPegs;
    }

    public void setFootPegs(String footPegs) {
        this.footPegs = footPegs;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", motorcycleId=" + motorcycleId +
                ", indicators='" + indicators + '\'' +
                ", indicatorsDescription='" + indicatorsDescription + '\'' +
                ", oil='" + oil + '\'' +
                ", oilLevel='" + oilLevel + '\'' +
                ", brakeFluid='" + brakeFluid + '\'' +
                ", clutchFluid='" + clutchFluid + '\'' +
                ", coolant='" + coolant + '\'' +
                ", lightsGood='" + lightsGood + '\'' +
                ", mirrors='" + mirrors + '\'' +
                ", horn='" + horn + '\'' +
                ", tank='" + tank + '\'' +
                ", frontTire='" + frontTire + '\'' +
                ", rearTire='" + rearTire + '\'' +
                ", engine='" + engine + '\'' +
                ", chassis='" + chassis + '\'' +
                ", throttle='" + throttle + '\'' +
                ", exhaust='" + exhaust + '\'' +
                ", transmission='" + transmission + '\'' +
                ", clutch='" + clutch + '\'' +
                ", brakes='" + brakes + '\'' +
                ", chain='" + chain + '\'' +
                ", footPegs='" + footPegs + '\'' +
                ", mileage='" + mileage + '\'' +
                ", fuel='" + fuel + '\'' +
                '}';
    }
}
