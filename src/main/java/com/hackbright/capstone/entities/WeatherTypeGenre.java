package com.hackbright.capstone.entities;

import com.hackbright.capstone.dtos.WeatherTypeGenreDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "WeatherTypeGenres")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherTypeGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weatherType_id", referencedColumnName = "id")
    private WeatherType weatherType;

    public WeatherTypeGenre(WeatherTypeGenreDto weatherTypeGenreDto) {
        if (weatherTypeGenreDto.getId() != null) {
            this.id = weatherTypeGenreDto.getId();
        }
    }
}
