package Controller;

import Beans.User;
import Beans.Util.UserRole;
import Beans.Util.UserStatus;
import Services.Interfaces.UserService;
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

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return (user != null) ?
                new ResponseEntity<>(user, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.updateUser(user);
        return (updatedUser != null) ?
                new ResponseEntity<>(updatedUser, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Solo en caso de borrado definitivo
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Otros métodos de punto final según sea necesario

    @PutMapping("/{id}/change-password")
    public ResponseEntity<User> changeUserPassword(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.changeUserPassword(user);
        return (updatedUser != null) ?
                new ResponseEntity<>(updatedUser, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Método por defecto para borrar
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}/change-status")
    public ResponseEntity<User> changeUserStatus(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.changeUserStatus(user);
        return (updatedUser != null) ?
                new ResponseEntity<>(updatedUser, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{id}/add-role")
    public ResponseEntity<User> addUserRole(@PathVariable Integer id, @RequestParam UserRole role) {
        User user = userService.getUserById(id);
        if (user != null) {
            User updatedUser = userService.addUserRole(user, role);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}/delete-role")
    public ResponseEntity<User> deleteUserRole(@PathVariable Integer id, @RequestParam UserRole role) {
        User user = userService.getUserById(id);
        if (user != null) {
            User updatedUser = userService.deleteUserRole(user, role);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/by-role")
    public ResponseEntity<List<User>> getUsersByRole(@RequestParam UserRole role) {
        List<User> users = userService.getUsersByRole(role);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/by-status")
    public ResponseEntity<List<User>> getUsersByStatus(@RequestParam UserStatus status) {
        List<User> users = userService.getUsersByStatus(status);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
