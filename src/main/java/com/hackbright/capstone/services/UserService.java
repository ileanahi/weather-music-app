package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.UserDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    @Transactional
    List<String> userLogin(UserDto userDto);
}
