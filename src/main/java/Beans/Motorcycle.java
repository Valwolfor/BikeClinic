package Beans;

import jakarta.persistence.*;

@Entity
@Table(name = "motorcycle")
public class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plate;

    @Column(name = "engine_id")
    private String engineId;

    @Column(name = "chassis_id")
    private String chassisId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "registration_year")
    private String registrationYear;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getEngineId() {
        return engineId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }

    public String getChassisId() {
        return chassisId;
    }

    public void setChassisId(String chassisId) {
        this.chassisId = chassisId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(String registrationYear) {
        this.registrationYear = registrationYear;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "MotorCycle{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", engineId='" + engineId + '\'' +
                ", chassisId='" + chassisId + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", registrationYear='" + registrationYear + '\'' +
                ", customer=" + customer.getFirstName() + ' '+ customer.getLastName() + //
                '}';
    }
}
