//package com.motorclinic.services.implementations;
//
//import com.motorclinic.entity.User;
//import com.motorclinic.entity.util.UserRole;
//import com.motorclinic.entity.util.UserStatus;
//import com.motorclinic.repository.UserRepository;
//import com.motorclinic.services.interfaces.UserService;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//import java.util.Collections;
//import java.util.List;
//
//@Service
//@Transactional
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository repository;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
//        this.repository = repository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public User createUser(User user) {
//
//        String hashedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hashedPassword);
//
//        return repository.save(user);
//    }
//
//    /**
//     * Actualiza la información de un usuario existente.
//     * No permite la actualización de la contraseña ni el id o status, para eso debe usarse su método específico.
//     *
//     * @param user El usuario con la información actualizada.
//     * @return El usuario actualizado.
//     * @throws IllegalArgumentException Si el usuario o el ID son nulos.
//     * @throws EntityNotFoundException Si no se encuentra el usuario con el ID proporcionado.
//     */
//    @Override
//    public User updateUser(User user) {
//        if (user == null || user.getId() == null) {
//            // Manejar la situación en la que el usuario o el ID son nulos
//            throw new IllegalArgumentException("Usuario o ID nulos");
//        }
//        //Se guarda los parametros recibidos y los actualiza en el objeto existente usando transacciones.
//        User oldUser = repository.findById(user.getId()).orElse(null);
//        if (oldUser != null) {
//            oldUser.setEmail(user.getEmail());
//            oldUser.setContactNumber(user.getContactNumber());
//            oldUser.setFirstName(user.getFirstName());
//            oldUser.setLastName(user.getLastName());
//        }
//
//        if (oldUser == null) {
//            throw new EntityNotFoundException("Usuario no encontrado con ID: " + user.getId());
//        }
//        return repository.save(oldUser);
//    }
//
//    /**
//     * Cambia la contraseña de un usuario, además de cifrar y guardar el hash.
//     *
//     * @param user El usuario con la nueva contraseña.
//     * @return El usuario con la contraseña cambiada.
//     * @throws IllegalArgumentException Si el usuario, el ID o la contraseña son nulos.
//     * @throws EntityNotFoundException Si no se encuentra el usuario con el ID proporcionado.
//     */
//    @Override
//    public User changeUserPassword(User user) {
//        if (user == null || user.getId() == null || user.getPassword() == null) {
//            // Manejar la situación en la que el usuario o la contraseña son nulos
//            throw new IllegalArgumentException("Usuario o contraseña nulos");
//        }
//
//        User oldUser = repository.findById(user.getId()).orElse(null);
//        if (oldUser != null) {
//            String newPassword = passwordEncoder.encode(user.getPassword());
//            oldUser.setPassword(newPassword);
//        }
//
//        if (oldUser == null) {
//            throw new EntityNotFoundException("Usuario no encontrado con ID: " + user.getId());
//        }
//        return repository.save(oldUser);
//    }
//
//    /**
//     * Forma de borrado por defecto
//     * @param user que se va a cambiar
//     * @return User con changed status
//     */
//    @Override
//    public User changeUserStatus(User user) {
//        User oldUser = repository.findById(user.getId()).orElse(null);
//        if (oldUser != null) {
//            oldUser.setStatus(user.getStatus());
//        }
//        assert oldUser != null;
//        return repository.save(oldUser);
//    }
//
//
//    @Override
//    public User addUserRole(User user, UserRole role) {
//        if (user == null || role == null) {
//            throw new IllegalArgumentException("Usuario o rol nulos");
//        }
//
//        User oldUser = repository.findById(user.getId()).orElse(null);
//        if (oldUser != null) {
//            if (!oldUser.getRoles().contains(role)) {
//                List<UserRole> roles = oldUser.getRoles();
//                roles.add(role);
//                oldUser.setRoles(roles);
//            }
//
//        }
//
//        if (oldUser == null) {
//            throw new EntityNotFoundException("Usuario no encontrado con ID: " + user.getId());
//        }
//        return repository.save(oldUser);
//    }
//
//    //debe selecionarse el rol a aliminar
//    @Override
//    public User deleteUserRole(User user, UserRole role) {
//        //Verifica que no venga vacío los datos.
//        if (user == null || role == null) {
//            throw new IllegalArgumentException("Usuario o rol nulos");
//        }
//
//        User oldUser = repository.findById(user.getId()).orElse(null);
//        if (oldUser != null && oldUser.getRoles().contains(role)) {
//            List<UserRole> roles = oldUser.getRoles();
//            roles.remove(role);
//            oldUser.setRoles(roles);
//
//        } else {
//            throw new EntityNotFoundException("Usuario no encontrado con ID: " + user.getId() + " o el rolo no está asignado en este usuario");
//        }
//
//        return repository.save(oldUser);
//    }
//
//    @Override
//    public void deleteUser(Integer id) {
//        repository.deleteById(id);
//    }
//
//    @Override
//    public User getUserById(Integer id) {
//        return repository.getReferenceById(id);
//    }
//
//    @Override
//    public User getUserByEmail(String email) {
//        return repository.findByEmail(email);
//    }
//
//    @Override
//    public List<User> getUsersByRole(UserRole role) {
//        return repository.findAllByRoles(Collections.singletonList(role));
//    }
//    @Override
//    public List<User> getUsersByStatus(UserStatus status) {
//        return repository.findAllByStatus(status);
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return repository.findAll();
//    }
//}
