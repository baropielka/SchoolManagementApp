package com.schoolapp.schoolmanagementapplication.auth;

import lombok.*;

import java.util.Objects;

@Data
@Builder
public class UserSto {
    private long id;
    private String firstName;
    private String lastName;
    private String login;
    private String token;
}
