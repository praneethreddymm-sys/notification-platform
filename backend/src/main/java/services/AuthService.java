package com.notification.notification_system.services;

import com.notification.notification_system.dto.AuthRequest;
import com.notification.notification_system.entity.User;
import com.notification.notification_system.repository.UserRepository;
import com.notification.notification_system.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        return "User Registered Successfully";
    }

    public String login(AuthRequest request) {
        // Unwraps the Optional<User> returned by findByEmail safely
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}