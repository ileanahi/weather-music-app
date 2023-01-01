package com.hackbright.capstone.dtos;

import com.hackbright.capstone.entities.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto implements Serializable {
    private Long id;
    private String type;
    private Set<WeatherTypeGenreDto> weatherTypeGenreDtoSet = new HashSet<>();

    public GenreDto(Genre genre) {
        if (genre.getId() != null) {
            this.id = genre.getId();
        }
        if (genre.getType() != null) {
            this.type = genre.getType();
        }
    }
}
