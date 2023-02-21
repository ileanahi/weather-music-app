package com.hackbright.capstone.entities;

import com.hackbright.capstone.dtos.WeatherTypeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "WeatherTypes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public WeatherType(WeatherTypeDto weatherTypeDto) {
        if (weatherTypeDto.getType() != null) {
            this.type = weatherTypeDto.getType();
        }
        if (weatherTypeDto.getGenre() != null) {
            this.genre = weatherTypeDto.getGenre();
        }
    }
}
