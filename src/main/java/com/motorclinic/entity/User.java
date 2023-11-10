
package com.motorclinic.entity;

import com.motorclinic.entity.util.UserRole;
import com.motorclinic.entity.util.UserStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user")
public class User extends Person {
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus status;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private List<UserRole> roles;

    public User() {
        // Empty constructor
    }

    public User(UserStatus status, String password, UserRole role, int id, String firstName, String lastName, String email, String contactNumber) {
        super(id, firstName, lastName, email, contactNumber);
        this.status = status;
        this.password = password;
        this.roles = new ArrayList<>();
        this.roles.add(role);
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRole> getRoles() {
        return roles;
    }


    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", contactNumber='" + getContactNumber() + '\'' +
                ", status='" + status + '\'' +
                ", password='" + password + '\'' +
                ", role='" + roles + '\'' +
                '}';
    }
}

