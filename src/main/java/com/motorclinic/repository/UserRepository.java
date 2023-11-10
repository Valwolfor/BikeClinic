package com.motorclinic.repository;

import com.motorclinic.entity.User;
import com.motorclinic.entity.util.UserRole;
import com.motorclinic.entity.util.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.roles = :role")
    List<User> findAllByRole(@Param("role") UserRole role);


    void deleteById(Integer id);

    List<User> findAllByStatus(UserStatus status);
}
