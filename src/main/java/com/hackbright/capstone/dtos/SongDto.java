package com.hackbright.capstone.dtos;

import com.hackbright.capstone.entities.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDto implements Serializable {
    private Long id;
    private String title;
    private String artist;
    private String albumArt;
    private UserDto userDto;

    public SongDto(Song song) {
        if (song.getId() != null) {
            this.id = song.getId();
        }
        if (song.getTitle()!= null) {
            this.title = song.getTitle();
        }
        if (song.getArtist()!= null) {
            this.artist = song.getArtist();
        }
        if (song.getAlbumArt()!= null) {
            this.albumArt = song.getAlbumArt();
        }
    }
}
