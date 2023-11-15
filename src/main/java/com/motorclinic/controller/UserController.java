package com.motorclinic.controller;

import com.motorclinic.entity.DTO.UserDTO;
import com.motorclinic.entity.User;
import com.motorclinic.entity.util.UserRole;
import com.motorclinic.entity.util.UserStatus;
import com.motorclinic.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //check
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);

        if (user != null) {
            UserDTO userDTO = new UserDTO(user);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Check
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    //TODO: DTO devuelve todo. contra y esas vainas se debe arreglar.
    //Checked
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        // Verificar si el usuario existe
        User existingUser = userService.getUserById(id);

        if (existingUser != null) {
            // Actualizar los campos relevantes del usuario existente
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setContactNumber(user.getContactNumber());
            // Guardar los cambios
            User updatedUser = userService.updateUser(existingUser);

            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            // El usuario no existe, devolver un código 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Solo en caso de borrado definitivo
     *Checked.
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Check
    @PutMapping("/{id}/change-password")
    public ResponseEntity<User> changeUserPassword(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.changeUserPassword(user);
        return (updatedUser != null) ?
                new ResponseEntity<>(updatedUser, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Método por defecto para borrar. Checked
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}/change-status")
    public ResponseEntity<User> changeUserStatus(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.changeUserStatus(user);
        return (updatedUser != null) ?
                new ResponseEntity<>(updatedUser, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Checked
    @PostMapping("/{id}/add-role")
    public ResponseEntity<User> addUserRole(@PathVariable Long id, @RequestParam UserRole role) {
        User user = userService.getUserById(id);
        if (user != null) {
            User updatedUser = userService.addUserRole(user, role);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //Checked
    @DeleteMapping("/{id}/delete-role")
    public ResponseEntity<User> deleteUserRole(@PathVariable Long id, @RequestParam UserRole role) {
        User user = userService.getUserById(id);
        if (user != null) {
            User updatedUser = userService.deleteUserRole(user, role);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Checked
    @GetMapping("/by-role")
    public ResponseEntity<List<User>> getUsersByRole(@RequestParam UserRole role) {
        List<User> users = userService.getUsersByRole(role);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Checked
    @GetMapping("/by-status")
    public ResponseEntity<List<User>> getUsersByStatus(@RequestParam UserStatus status) {
        List<User> users = userService.getUsersByStatus(status);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
