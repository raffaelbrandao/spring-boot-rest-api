package com.raffaelbrandao.demo.services;

import com.raffaelbrandao.demo.config.SecurityConfig;
import com.raffaelbrandao.demo.data.LoginRequest;
import com.raffaelbrandao.demo.data.SessionResponse;
import com.raffaelbrandao.demo.models.UserEntity;
import com.raffaelbrandao.demo.repositories.UserRepository;
import com.raffaelbrandao.demo.securities.JWTCreator;
import com.raffaelbrandao.demo.securities.JWTObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public SessionResponse login(LoginRequest loginRequest) {
        UserEntity userEntity = userRepository.findByUsername(loginRequest.getUsername());
        if (userEntity != null) {
            boolean isPasswordMatch = passwordEncoder.matches(loginRequest.getPassword(), userEntity.getPassword());
            if (!isPasswordMatch) {
                throw new RuntimeException("Invalid password for this login: " + loginRequest.getUsername());
            }

            SessionResponse sessionResponse = new SessionResponse();
            sessionResponse.setLogin(userEntity.getUsername());

            var jwtObject = getJWTObject(userEntity);
            sessionResponse.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessionResponse;
        } else {
            throw new RuntimeException("Error when logging in!");
        }
    }

    public JWTObject getJWTObject(UserEntity user) {
        JWTObject jwtObject = new JWTObject();
        jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
        jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
        jwtObject.setRoles(user.getRoles());

        return jwtObject;
    }
}
