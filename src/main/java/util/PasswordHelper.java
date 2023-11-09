package util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordHelper {
    private final PasswordEncoder passwordEncoder;

    public PasswordHelper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encryptPassword(String password){
        return passwordEncoder.encode(password);
    }

}
