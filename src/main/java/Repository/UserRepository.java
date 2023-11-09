package Repository;

import Beans.User;
import Beans.Util.UserRole;
import Beans.Util.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);
    User findByEmail(String email);
    List<User> findAllByRole(UserRole role);

    void deleteById(Long id);

    List<User> findAllByStatus(UserStatus status);
}
