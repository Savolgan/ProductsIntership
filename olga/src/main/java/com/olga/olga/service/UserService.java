package com.olga.olga.service;

import com.olga.olga.dao.UserDao;
import com.olga.olga.dto.UserDto;
import com.olga.olga.entity.Bucket;
import com.olga.olga.entity.User;
import com.olga.olga.exception.ClassNotFoundException;
import com.olga.olga.mapping.UserMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    private final UserMapper userMapper;

    public User getUserById(Integer id) {
        return userDao.findById(id).orElseThrow(() ->
                new ClassNotFoundException("User not found, id is incorrect"));
    }

    public User saveUser(UserDto userDto){
        return userDao.save(userMapper.mapToUser(userDto));
    }

    public List<User> getAllUsers(){
        List<User> userList=new ArrayList<>();
        userDao.findAll().forEach(user -> userList.add(user));
        return userList;
    }
}
