package com.olga.olga.mapping;

import com.olga.olga.dto.UserDto;
import com.olga.olga.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        return user;
    }
}
