package com.olga.olga.dto;

import com.olga.olga.entity.Bucket;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    private  String name;
    private Integer id;
    Bucket bucket;
}
