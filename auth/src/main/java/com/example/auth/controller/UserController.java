package com.example.auth.controller;

import com.example.auth.dto.UserDto;
import com.example.auth.entity.User;
import com.example.auth.exception.*;
import com.example.auth.response.UserResponse;
import com.example.auth.service.UserService;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public UserResponse addUser(@RequestBody UserDto userDto)throws RegisterException {
        return userService.addUser(userDto);
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody UserDto userDto)throws UserLoginException {
        return userService.login(userDto);
    }
    @DeleteMapping("/delete/{userId}")
    public UserResponse deleteUser(@PathVariable int userId)throws DeleteUserException {
        return userService.deleteUser(userId);
    }
    @GetMapping("/find/{userId}")
    public UserResponse find(@PathVariable (value = "userId") int userId) throws FindException {

        return userService.find(userId);
    }
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable (value = "userId") int userId, @RequestBody UserDto userDto) throws UpdateUserException {
        return ResponseEntity.ok(userService.updateUser(userId,userDto));
    }


}
