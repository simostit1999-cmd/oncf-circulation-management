package demo.reactAdmin.oncf.service;

import demo.reactAdmin.oncf.entity.User;
import demo.reactAdmin.oncf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Enregistrer un nouvel utilisateur
    public User saveUser(User user) {
        // Chiffrer le mot de passe avant d’enregistrer
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Rechercher un utilisateur par username
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Vérifier si username existe
    public boolean existsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
