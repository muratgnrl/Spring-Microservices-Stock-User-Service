package com.example.auth.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserDto implements Serializable {

    public int userId;

    public String name;

    public String lastName;

    public String mail;

    public String password;

}
