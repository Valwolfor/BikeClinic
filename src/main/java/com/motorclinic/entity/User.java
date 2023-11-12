
package com.motorclinic.entity;

import com.motorclinic.entity.util.UserRole;
import com.motorclinic.entity.util.UserStatus;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "user")
public class User extends Person {

    @Column(name = "password", nullable = false)
    private String password;

    @ElementCollection(targetClass = UserRole.class)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", columnDefinition = "VARCHAR(255)")
    @Enumerated(EnumType.STRING)
    private List<UserRole> roles;


    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    public User() {
        // Empty constructor
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

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", roles=" + roles +
                ", status=" + status +
                '}';
    }
}

