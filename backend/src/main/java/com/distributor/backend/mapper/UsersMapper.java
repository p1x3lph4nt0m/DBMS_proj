package com.distributor.backend.mapper;

import com.distributor.backend.dto.UsersDto;
import com.distributor.backend.entity.Users;

public class UsersMapper {
    public static UsersDto maptoUsersDto(Users user){
        return new UsersDto(
                user.getUsername(),
                user.getPassword()
        );
    }

    public static Users maptoUsers(UsersDto userDto){
        return new Users(
                userDto.getUsername(),
                userDto.getPassword()
        );
    }
}
