package com.motorclinic.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends Person {

    @Column(name = "type_id")
    private String typeId;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", contactNumber='" + getContactNumber() + '\'' +
                ", typeId='" + typeId + '\'' +
                '}';
    }
}