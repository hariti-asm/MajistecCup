package ma.hariti.asmaa.wrm.majesticcup.service;

import ma.hariti.asmaa.wrm.majesticcup.config.JWTService;
import ma.hariti.asmaa.wrm.majesticcup.entity.User;
import ma.hariti.asmaa.wrm.majesticcup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final JWTService jwtService;

    private final AuthenticationManager authManager;

    private final UserRepository userRepository;

public UserService(JWTService jwtService, AuthenticationManager authManager, UserRepository userRepository) {
    this.jwtService = jwtService;
    this.authManager = authManager;
    this.userRepository = userRepository;
}
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    public String verify(User user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "fail";
        }
    }
}
