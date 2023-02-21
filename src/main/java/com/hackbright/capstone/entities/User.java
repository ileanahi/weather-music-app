package com.hackbright.capstone.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hackbright.capstone.dtos.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String firstName;

    @Column
    private String password;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private Set<Song> songs;

    public Set<Song> getSongs() {
        return songs;
    }
    public void setSongs(Set<Song> patients) {
            this.songs = songs;
    }

    public User(UserDto userDto) {
        if (userDto.getUsername() != null) {
            this.username = userDto.getUsername();
        }
        if (userDto.getFirstName() != null) {
            this.firstName = userDto.getFirstName();
        }
        if (userDto.getPassword() != null) {
            this.password = userDto.getPassword();
        }
    }
}
