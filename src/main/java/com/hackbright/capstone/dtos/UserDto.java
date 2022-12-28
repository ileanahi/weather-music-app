package com.hackbright.capstone.dtos;

import com.hackbright.capstone.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String username;
    private String firstName;
    private String email;
    private String password;
    private String location;
    private String role;
    private Set<FavoriteSongDto> favoriteSongDtoSet = new HashSet<>();

    public UserDto(User user) {
        if (user.getId() != null){
            this.id = user.getId();
        }
        if (user.getUsername() != null) {
            this.username = user.getUsername();
        }
        if (user.getFirstName() != null) {
            this.firstName = user.getFirstName();
        }
        if (user.getEmail()!= null) {
            this.email = user.getEmail();
        }
        if (user.getPassword()!= null) {
            this.password = user.getPassword();
        }
        if (user.getLocation()!= null) {
            this.location = user.getLocation();
        }
        if (user.getRole()!= null) {
            this.role = user.getRole();
        }
    }
}