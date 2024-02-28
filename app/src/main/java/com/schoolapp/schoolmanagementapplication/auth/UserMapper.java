package com.schoolapp.schoolmanagementapplication.auth;

import org.mapstruct.Mapper;

@Mapper(componentModel = "string")
public interface UserMapper {
    UserSto toUserSto(UserEntity user);
}
