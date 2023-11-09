package Services.Implementations;

import Beans.User;
import Beans.Util.UserRole;
import Beans.Util.UserStatus;
import Repository.UserRepository;
import Services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User oldUser = repository.findById(user.getId()).orElse(null);
        if (oldUser != null) {
            oldUser.setEmail(user.getEmail());
            oldUser.setContactNumber(user.getContactNumber());
            oldUser.setFirstName(user.getFirstName());
            oldUser.setLastName(user.getLastName());
        }
        assert oldUser != null;
        return repository.save(oldUser);
    }

    @Override
    public User changeUserPassword(User user) {
        //TODO: Aquí se podría hacer validación de patrón y conversión del hash.
        User oldUser = repository.findById(user.getId()).orElse(null);
        if (oldUser != null) {
            oldUser.setPassword(user.getPassword());
        }
        assert oldUser != null;
        return repository.save(oldUser);
    }

    @Override
    public User changeUserStatus(User user) {
        User oldUser = repository.findById(user.getId()).orElse(null);
        if (oldUser != null) {
            oldUser.setStatus(user.getStatus());
        }
        assert oldUser != null;
        return repository.save(oldUser);
    }


    @Override
    public User addUserRole(User user, UserRole role) {
        User oldUser = repository.findById(user.getId()).orElse(null);
        if (oldUser != null) {
            oldUser.setRole(role);
        }
        assert oldUser != null;
        return repository.save(oldUser);
    }

    //debe selecionarse el rol a aliminar
    @Override
    public User deleteUserRole(User user, UserRole role) {
        User oldUser = repository.findById(user.getId()).orElse(null);
        if (oldUser != null && oldUser.getRoles().size() >= 1) {

            oldUser.getRoles().remove(role);
        }
        assert oldUser != null;
        return repository.save(oldUser);
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public User getUserById(Integer id) {
        return repository.getReferenceById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<User> getUsersByRole(UserRole role) {
        return repository.findAllByRole(role);
    }

    @Override
    public List<User> getUsersByStatus(UserStatus status) {
        return repository.findAllByStatus(status);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
