package com.hackbright.capstone.dtos;

import com.hackbright.capstone.entities.FavoriteSong;
import com.hackbright.capstone.entities.Song;
import com.hackbright.capstone.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteSongDto implements Serializable {
    private Long id;
    private User user;
    private Song song;

    public FavoriteSongDto(FavoriteSong favoriteSong) {
        if (favoriteSong.getId() != null) {
            this.id = favoriteSong.getId();
        }
    }
}
