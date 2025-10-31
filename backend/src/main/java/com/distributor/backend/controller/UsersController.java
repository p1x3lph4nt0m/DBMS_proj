package com.distributor.backend.controller;

import com.distributor.backend.dto.UsersDto;
import com.distributor.backend.service.UsersService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping()
public class UsersController {
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<?>user_login(@RequestBody UsersDto usersDto, HttpServletResponse response){
        UsersDto loggedInUser = usersService.confirm_login(usersDto);

        if (loggedInUser == null) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
        Cookie cookie = new Cookie("session_id", loggedInUser.getUsername());
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        return ResponseEntity.ok(loggedInUser);
    }

    @GetMapping("/authorize")
    public ResponseEntity<?> authorize(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("session_id")) {
                    return ResponseEntity.ok("Authorized");
                }
            }
        }

        return ResponseEntity.status(401).body("Unauthorized");
    }

}
