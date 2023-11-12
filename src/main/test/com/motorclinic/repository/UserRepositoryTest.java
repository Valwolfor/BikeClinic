package com.motorclinic.repository;

import com.motorclinic.entity.User;
import com.motorclinic.entity.util.UserRole;
import com.motorclinic.entity.util.UserStatus;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    @Rollback
    void testSaveUserWithRoles() {
        // Arrange
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setContactNumber("123");
        user.setPassword("password");
        user.setStatus(UserStatus.ACTIVE);

        List<UserRole> roles = Arrays.asList(UserRole.MECHANIC, UserRole.ADMIN);
        user.setRoles(roles);

        // Act
        User savedUser = userRepository.save(user);

        // Assert
        assertNotNull(savedUser.getId());
        assertEquals("John", savedUser.getFirstName());
        assertEquals("Doe", savedUser.getLastName());
        assertEquals("john.doe@example.com", savedUser.getEmail());
        assertEquals("123", savedUser.getContactNumber());
        assertEquals(roles, savedUser.getRoles());
        assertEquals(UserStatus.ACTIVE, savedUser.getStatus());
    }

    @Test
    @Transactional
    @Rollback
    void testFindUserByEmail() {
        // Arrange
        User user = new User();
        user.setFirstName("Jane");
        user.setLastName("Smith");
        user.setEmail("jane.smith@example.com");
        user.setContactNumber("456");
        user.setPassword("password");
        user.setStatus(UserStatus.ACTIVE);

        List<UserRole> roles = Collections.singletonList(UserRole.ASSISTANT);
        user.setRoles(roles);

        User savedUser = userRepository.save(user);

        // Act
        User foundUser = userRepository.findByEmail("jane.smith@example.com");

        // Assert
        assertNotNull(foundUser);
        assertEquals(savedUser.getId(), foundUser.getId());
        assertEquals("Jane", foundUser.getFirstName());
        assertEquals("Smith", foundUser.getLastName());
        assertEquals("jane.smith@example.com", foundUser.getEmail());
        assertEquals("456", foundUser.getContactNumber());
        assertEquals(roles, foundUser.getRoles());
        assertEquals(UserStatus.ACTIVE, savedUser.getStatus());
    }

    @Test
    @Transactional
    @Rollback
    void testFindAllByRoles() {
        // Arrange
        User user1 = new User();
        user1.setFirstName("Alice");
        user1.setLastName("Johnson");
        user1.setEmail("alice.johnson@example.com");
        user1.setContactNumber("789");
        user1.setPassword("password");
        user1.setStatus(UserStatus.ACTIVE);

        List<UserRole> roles1 = Collections.singletonList(UserRole.MECHANIC);
        user1.setRoles(roles1);

        User user2 = new User();
        user2.setFirstName("Bob");
        user2.setLastName("Williams");
        user2.setEmail("bob.williams@example.com");
        user2.setContactNumber("012");
        user2.setPassword("password1");
        user2.setStatus(UserStatus.ACTIVE);

        List<UserRole> roles2 = Collections.singletonList(UserRole.ADMIN);
        user2.setRoles(roles2);

        userRepository.save(user1);
        userRepository.save(user2);

        // Act

        List<User> foundUsers = userRepository.findByRolesIn(Arrays.asList(UserRole.ADMIN, UserRole.MECHANIC));

        // Assert
        assertNotNull(foundUsers);
        assertEquals(2, foundUsers.size());
        assertTrue(foundUsers.stream().anyMatch(u -> u.getEmail().equals("alice.johnson@example.com")));
        assertTrue(foundUsers.stream().anyMatch(u -> u.getEmail().equals("bob.williams@example.com")));
    }

    @Test
    @Transactional
    @Rollback
    void testUpdateUser() {
        // Arrange
        User user = new User();
        user.setFirstName("Mark");
        user.setLastName("Johnson");
        user.setEmail("mark.johnson@example.com");
        user.setContactNumber("345");
        user.setPassword("password");
        user.setStatus(UserStatus.ACTIVE);

        List<UserRole> originalRoles = Collections.singletonList(UserRole.ASSISTANT);
        user.setRoles(originalRoles);

        User savedUser = userRepository.save(user);

        // Act
        savedUser.setFirstName("UpdatedMark");
        savedUser.setContactNumber("678");
//        List<UserRole> updatedRoles = Arrays.asList(UserRole.MECHANIC, UserRole.ADMIN);
//        savedUser.setRoles(updatedRoles);

//        User updatedUser = userRepository.save(savedUser);

        // Assert
//        assertEquals(savedUser.getId(), updatedUser.getId());
//        assertEquals("UpdatedMark", updatedUser.getFirstName());
//        assertEquals("Johnson", updatedUser.getLastName());
//        assertEquals("mark.johnson@example.com", updatedUser.getEmail());
//        assertEquals("678", updatedUser.getContactNumber());
//        assertEquals(updatedRoles, updatedUser.getRoles());
        assertEquals(UserStatus.ACTIVE, savedUser.getStatus());
    }

    @Test
    @Transactional
    @Rollback
    void testDeleteUser() {
        // Arrange
        User user = new User();
        user.setFirstName("Eve");
        user.setLastName("Miller");
        user.setEmail("eve.miller@example.com");
        user.setContactNumber("901");
        user.setPassword("password");
        user.setStatus(UserStatus.ACTIVE);

        List<UserRole> roles =Collections.singletonList(UserRole.ADMIN);
        user.setRoles(roles);

        User savedUser = userRepository.save(user);

        // Act
        userRepository.deleteById(savedUser.getId());

        // Assert
        assertFalse(userRepository.existsById(savedUser.getId()));
    }
}
