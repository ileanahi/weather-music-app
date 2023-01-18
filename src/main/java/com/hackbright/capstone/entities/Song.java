package com.hackbright.capstone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hackbright.capstone.dtos.SongDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Songs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String artist;

    @Column
    private String albumArt;

    @ManyToOne
    @JsonBackReference
    private User user;


    public Song(SongDto songDto) {
        if (songDto.getTitle() != null) {
            this.title = songDto.getTitle();
        }
        if (songDto.getArtist() != null) {
            this.artist = songDto.getArtist();
        }
        if (songDto.getAlbumArt() != null) {
            this.albumArt = songDto.getAlbumArt();
        }
    }
}
