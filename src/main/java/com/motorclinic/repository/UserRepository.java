package com.motorclinic.repository;

import com.motorclinic.entity.User;
import com.motorclinic.entity.util.UserRole;
import com.motorclinic.entity.util.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findByRolesIn(List<UserRole> roles);
    void deleteById(Long id);

    List<User> findAllByStatus(UserStatus status);
}
