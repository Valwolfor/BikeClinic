
package Beans;

import Beans.Util.UserRole;
import Beans.Util.UserStatus;
import jakarta.persistence.*;


@Entity
public class User extends Person {
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus status;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    public User() {
        // Empty constructor
    }

    public User(UserStatus status, String password, UserRole role, int id, String firstName, String lastName, String email, String contactNumber) {
        super(id, firstName, lastName, email, contactNumber);
        this.status = status;
        this.password = password;
        this.role = role;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
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
                ", role='" + role + '\'' +
                '}';
    }
}

