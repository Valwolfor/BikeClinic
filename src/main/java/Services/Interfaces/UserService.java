package Services.Interfaces;

import Beans.User;
import Beans.Util.UserRole;
import Beans.Util.UserStatus;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    User changeUserPassword(User user);
    User changeUserStatus(User user);
    User addUserRole(User user, UserRole role);
    User deleteUserRole(User user, UserRole role);
    void deleteUser(Integer id);
    User getUserById(Integer id);
    User getUserByEmail(String email);
    List<User> getUsersByRole(UserRole role);
    List<User> getUsersByStatus(UserStatus status);
    List<User> getAllUsers();

}