package Repository;

import Beans.User;
import Beans.Util.UserRole;
import Beans.Util.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    @Query("SELECT u FROM User u WHERE :role MEMBER OF u.roles")
    List<User> findAllByRole(@Param("role") UserRole role);

    void deleteById(Integer id);

    List<User> findAllByStatus(UserStatus status);
}
