package com.motorclinic.services.interfaces;

import com.motorclinic.entity.User;
import com.motorclinic.entity.util.UserRole;
import com.motorclinic.entity.util.UserStatus;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    User changeUserPassword(User user);
    User changeUserStatus(User user);
    User addUserRole(User user, UserRole role);
    User deleteUserRole(User user, UserRole role);
    void deleteUser(Long id);
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getUsersByRole(UserRole role);
    List<User> getUsersByStatus(UserStatus status);
    List<User> getAllUsers();

}
