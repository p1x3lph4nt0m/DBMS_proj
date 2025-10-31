package com.distributor.backend.controller;

import com.distributor.backend.dto.UsersDto;
import com.distributor.backend.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/login")
public class UsersController {
    private UsersService usersService;

    @PostMapping
    public ResponseEntity<?>user_login(@RequestBody UsersDto usersDto){
        UsersDto loggedInUser = usersService.confirm_login(usersDto);

        if (loggedInUser == null) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        return ResponseEntity.ok(loggedInUser);
    }
}
