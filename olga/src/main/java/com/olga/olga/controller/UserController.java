package com.olga.olga.controller;

import com.olga.olga.dto.BucketDto;
import com.olga.olga.dto.UserDto;
import com.olga.olga.entity.User;
import com.olga.olga.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


}
