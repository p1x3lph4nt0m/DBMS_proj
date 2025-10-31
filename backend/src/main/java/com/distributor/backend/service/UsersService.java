package com.distributor.backend.service;

import com.distributor.backend.dto.UsersDto;


public interface UsersService {
    UsersDto confirm_login(UsersDto usersDto);
}
