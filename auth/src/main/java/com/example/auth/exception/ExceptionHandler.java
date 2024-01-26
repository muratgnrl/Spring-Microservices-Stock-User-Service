package com.example.auth.exception;

import com.example.auth.response.Meta;
import com.example.auth.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> loginException(UserLoginException loginException, WebRequest webRequest){
        UserResponse userResponse=new UserResponse();
        Meta meta=new Meta();
        meta.errorCode=4004;
        meta.errorDescription="Lütfen mail veya şifreniz size olduğundan emin olunuz";

        userResponse.meta=meta;
        ResponseEntity<Object> entity =new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> deleteException(DeleteUserException deleteUserException, WebRequest webRequest){
        UserResponse userResponse=new UserResponse();
        Meta meta=new Meta();
        meta.errorCode=4044;
        meta.errorDescription="Kullanıcı silinemedi";

        userResponse.meta=meta;
        ResponseEntity<Object> entity =new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> findException(FindException findException, WebRequest webRequest){
        UserResponse userResponse=new UserResponse();
        Meta meta=new Meta();
        meta.errorCode=4003;
        meta.errorDescription="Kullanıcı Bulunamadı";

        userResponse.meta=meta;
        ResponseEntity<Object> entity =new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> updateUser(UpdateUserException updateUser, WebRequest webRequest){
        UserResponse userResponse=new UserResponse();
        Meta meta=new Meta();
        meta.errorCode=4008;
        meta.errorDescription="Kullanıcı Güncellenemedi";

        userResponse.meta=meta;
        ResponseEntity<Object> entity =new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
}
