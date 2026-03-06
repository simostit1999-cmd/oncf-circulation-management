package demo.reactAdmin.oncf.controller;

import demo.reactAdmin.oncf.entity.User;
import demo.reactAdmin.oncf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Connexion
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        Optional<User> userOptional = userService.findByUsername(loginRequest.getUsername());

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(401).body("Utilisateur non trouvé");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Mot de passe incorrect");
        }

        // Ici on pourra générer un JWT pour sécuriser les requêtes
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
        return ResponseEntity.ok(token);
    }

    // Inscription (optionnel pour ADMIN)
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User newUser) {
        if (userService.existsByUsername(newUser.getUsername())) {
            return ResponseEntity.badRequest().body("Nom d’utilisateur déjà utilisé");
        }

        userService.saveUser(newUser);
        return ResponseEntity.ok("Utilisateur créé : " + newUser.getUsername());
    }
}
