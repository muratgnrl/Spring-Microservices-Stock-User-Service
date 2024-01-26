package com.example.auth.repo;

import com.example.auth.dto.UserDto;
import com.example.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByMailAndPassword(String mail, String password);

    User findUserByUserId(int userId);
}
