package com.example.auth.mapper;

import com.example.auth.dto.UserDto;
import com.example.auth.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends IEntityMapper<UserDto, User>{
}
