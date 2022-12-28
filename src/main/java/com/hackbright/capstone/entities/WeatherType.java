package com.hackbright.capstone.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String weatherType;
}
