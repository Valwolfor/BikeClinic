package com.motorclinic.entity.DTO;

import com.motorclinic.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {

    private Long id;
    private String contactNumber;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private List<String> roles;
    private String status;

    // Constructor, getters, setters

    public UserDTO(User user) {
        setId(user.getId());
        setContactNumber(user.getContactNumber());
        setEmail(user.getEmail());
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setPassword(user.getPassword());
        setRoles(user.getRoles().stream().map(Enum::name).collect(Collectors.toList()));
        setStatus(user.getStatus().name());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
