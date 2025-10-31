package com.distributor.backend.service.impl;

import com.distributor.backend.dto.UsersDto;
import com.distributor.backend.entity.Users;
import com.distributor.backend.exception.ResourceNotFoundException;
import com.distributor.backend.mapper.UsersMapper;
import com.distributor.backend.repository.UsersRepository;
import com.distributor.backend.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;
    @Override
    public UsersDto confirm_login(UsersDto usersDto) {
        Users user = usersRepository.findByUsername(usersDto.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found with username: " + usersDto.getUsername()
                ));

        if (!user.getPassword().equals(usersDto.getPassword())) {
            throw new ResourceNotFoundException(
                    "Incorrect password for username: " + usersDto.getUsername()
            );
        }

        return UsersMapper.maptoUsersDto(user);
    }
}
