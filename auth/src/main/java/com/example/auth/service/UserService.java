package com.example.auth.service;

import com.example.auth.dto.UserDto;
import com.example.auth.entity.User;
import com.example.auth.exception.*;
import com.example.auth.mapper.UserMapper;
import com.example.auth.repo.UserRepository;
import com.example.auth.response.Meta;
import com.example.auth.response.UserResponse;
import org.hibernate.annotations.processing.Find;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserService(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public UserResponse addUser(UserDto userDto) throws RegisterException {
        User user = mapper.toEntity(userDto);
        user = userRepository.save(user);

        if (user != null) {
            UserResponse userResponse = new UserResponse();
            userResponse.meta = new Meta(200, "Kayıt başarılı");
            userResponse.user = mapper.toResource(user);
            return userResponse;
        }
        throw new RegisterException();

    }


    public UserResponse login(UserDto userDto) throws UserLoginException {
        User user = userRepository.findUserByMailAndPassword(userDto.mail, userDto.password);

        if (user != null) {
            UserResponse userResponse = new UserResponse();
            userResponse.meta = new Meta(200, "Giriş başarılı");
            userResponse.user = mapper.toResource(user);
            return userResponse;
        }
        throw new UserLoginException();
    }


    public UserResponse deleteUser(int userId) throws DeleteUserException {
        Optional<User> userOptional = userRepository.findById(userId); //todo userOptional null  degilse yani isPresent.
        if (userOptional.isPresent()) {

            userRepository.deleteById(userId);

            UserResponse userResponse = new UserResponse();
            userResponse.meta = new Meta(200, "Kullanıcı silindi");
            return userResponse;

        } else {
            throw new DeleteUserException();
        }
    }


    public UserResponse find(int userId) throws FindException {
        User user = findUserByUserId(userId);

        if (user != null) {
            UserResponse userResponse=new UserResponse();
            userResponse.user = mapper.toResource(user);
            userResponse.meta=new Meta(200,"Kullanıcı Bulundu");
            return userResponse;
        } else {
            throw new FindException();
        }
    }

    private User findUserByUserId(int userId) {
        User user=userRepository.findUserByUserId(userId);
        return user;
    }


    public User updateUser(int userId, UserDto userDto) throws UpdateUserException {
        Optional<User> updateUser=userRepository.findById(userId);
        if (updateUser.isPresent()) {
            User toSaveUser = updateUser.get();
            toSaveUser.setName(userDto.getName());
            toSaveUser.setPassword(userDto.getPassword());
            toSaveUser.setMail(userDto.getMail());
            toSaveUser.setLastName(userDto.getLastName());

            return userRepository.save(toSaveUser);
        }
        throw new UpdateUserException();
    }
}

