package com.schoolapp.schoolmanagementapplication.auth;

import com.schoolapp.schoolmanagementapplication.exception.AuthorizationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    public UserSto login(CredentialsSto credentials) {
        UserEntity user = userRepository.findByLogin(credentials.login()).orElseThrow(() -> new AuthorizationException("User not found", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentials.password()), user.getPassword())) {
            return userMapper.toUserSto(user);
        }

        throw new AuthorizationException("Invalid password", HttpStatus.BAD_REQUEST);
    }
}
