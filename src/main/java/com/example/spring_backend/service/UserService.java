package com.example.spring_backend.service;

import com.example.spring_backend.model.User;
import com.example.spring_backend.repsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) throws Exception {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        byte[] salt = generateSalt();
        String hashedPassword = hashPassword(user.getPassword(), salt);

        String storedPassword = Base64.getEncoder().encodeToString(salt) + ":" + hashedPassword;
        user.setPassword(storedPassword);

        return userRepository.save(user);
    }

    private String hashPassword(String password, byte[] salt) throws Exception {
        int iterations = 100000;
        int keyLength = 256;

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hash);
    }

    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // 16 bytes = 128 bits
        random.nextBytes(salt);
        return salt;
    }
}