package com.schoolapp.schoolmanagementapplication.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserSto> login(@RequestBody CredentialsSto credentials) {
        UserSto user = userService.login(credentials);
        return ResponseEntity.ok(user);
    }
}
