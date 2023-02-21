package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.UserDto;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    @Transactional
    List<String> userLogin(UserDto userDto);

    Optional<UserDto> getUserById(@PathVariable Long id);
}
