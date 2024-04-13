package com.magret.controller;

import com.magret.model.User;
import com.magret.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(service.getAllUsers() , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<User>(service.createUser(user),HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<User>> getUserByName(@PathVariable Long userId){
        return new ResponseEntity<Optional<User>>(service.getUserByUserId(userId),HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId , @RequestBody User user){
        return new ResponseEntity<User>(service.updateUserOrCreateUser(userId , user),HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserByUserId(@PathVariable Long userId){
        service.deleteUser(userId);
        return new ResponseEntity<String>("User deleted Successfully" , HttpStatus.OK);
    }

}
