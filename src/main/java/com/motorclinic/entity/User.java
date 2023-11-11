
package com.motorclinic.entity;

import com.motorclinic.entity.util.UserRole;
import com.motorclinic.entity.util.UserRoleConverter;
import com.motorclinic.entity.util.UserStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "user")
public class User extends Person {

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "roles", nullable = false)
    @Enumerated(EnumType.STRING)
    @Convert(converter = UserRoleConverter.class)
    private UserRole roles;

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

    public UserRole getRoles() {
        return roles;
    }

    public void setRoles(UserRole roles) {
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

