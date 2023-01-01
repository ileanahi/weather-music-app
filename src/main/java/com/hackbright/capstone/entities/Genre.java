package com.hackbright.capstone.entities;

import com.hackbright.capstone.dtos.GenreDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Genres")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @OneToOne(mappedBy = "genre")
    private WeatherTypeGenre weatherTypeGenre;

    public Genre(GenreDto genreDto) {
        if (genreDto.getType() != null) {
            this.type = genreDto.getType();
        }
    }
}
