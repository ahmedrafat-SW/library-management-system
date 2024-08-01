package com.dev.librarymanagementsystem.controller;

import com.dev.librarymanagementsystem.model.User;
import com.dev.librarymanagementsystem.service.UserService;
import com.dev.librarymanagementsystem.util.LibraryResponse;
import com.dev.librarymanagementsystem.util.LibraryResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userDetailsService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        LibraryResponse response = new LibraryResponse<>();
        try {
            User user = userDetailsService.getUserById(id);
            response.setData(user);
            response.setCode(LibraryResponseCode.SUCCESS.getCode());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllUsers() {
        LibraryResponse response = new LibraryResponse<>();
        try {
            List<User> user = userDetailsService.getAll();
            response.setData(user);
            response.setCode(LibraryResponseCode.SUCCESS.getCode());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user){
        LibraryResponse response = new LibraryResponse<>();
        try {
            User savedUser = userDetailsService.saveUser(user);
            response.setData(savedUser);
            response.setCode(LibraryResponseCode.SUCCESS.getCode());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user){
        LibraryResponse response = new LibraryResponse<>();
        try {
            User savedUser = userDetailsService.updateUser(id, user);
            response.setData(savedUser);
            response.setCode(LibraryResponseCode.SUCCESS.getCode());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
