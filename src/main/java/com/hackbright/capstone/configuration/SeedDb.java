package com.hackbright.capstone.configuration;

import com.hackbright.capstone.entities.Genre;
import com.hackbright.capstone.entities.Song;
import com.hackbright.capstone.entities.User;
import com.hackbright.capstone.entities.WeatherType;
import com.hackbright.capstone.repositories.GenreRepository;
import com.hackbright.capstone.repositories.SongRepository;
import com.hackbright.capstone.repositories.UserRepository;
import com.hackbright.capstone.repositories.WeatherTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class SeedDb implements CommandLineRunner {
    @Autowired
    GenreRepository genreRepository;

    @Autowired
    SongRepository songRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WeatherTypeRepository weatherTypeRepository;

    @Override
    public void run(String ... args) throws Exception {
        User user1 = new User(null, "tomato", "Fatma", "tomatoes", null);
        Song song1 = new Song(null, "Flowers", "Miley Cyrus", "https://is1-ssl.mzstatic.com/image/thumb/Music123/v4/9e/80/c7/9e80c757-6994-4338-9e79-b92d5f75f788/196589561725.jpg/400x400cc.jpg", user1);

        Genre pop = new Genre(null, "POP", null);
        Genre house = new Genre(null, "HOUSE", null);
        Genre soulRnb = new Genre(null, "SOUL_RNB", null);
        Genre alternative = new Genre(null, "ALTERNATIVE", null);
        Genre electronic = new Genre(null, "ELECTRONIC", null);
        Genre singerSongwriter = new Genre(null, "SINGER_SONGWRITER", null);
        Genre dance = new Genre(null, "DANCE", null);
        Genre rock = new Genre(null, "ROCK", null);
        Genre country = new Genre(null, "COUNTRY", null);

        // Genres
        genreRepository.save(pop);
        genreRepository.save(country);
        genreRepository.save(electronic);
        genreRepository.save(rock);
        genreRepository.save(dance);
        genreRepository.save(singerSongwriter);
        genreRepository.save(alternative);
        genreRepository.save(soulRnb);
        genreRepository.save(house);

        // Clear
        WeatherType clear = new WeatherType(null, "clear", pop);

        // Thunderstorm
        WeatherType thunderstorm = new WeatherType(null, "thunderstorm", house);

        // Drizzle
        WeatherType drizzle = new WeatherType(null, "drizzle", null);

        // Rain
        WeatherType rain = new WeatherType(null, "rain", null);

        // Squall
        WeatherType squall = new WeatherType(null, "squall", null);

        // Tornado
        WeatherType tornado = new WeatherType(null, "tornado", null);

        // Clouds
        WeatherType clouds = new WeatherType(null, "clouds", null);

        // Snow
        WeatherType snow = new WeatherType(null, "snow", null);

        WeatherType mist = new WeatherType(null, "mist", null);

        WeatherType haze = new WeatherType(null, "haze", null);
        WeatherType dust = new WeatherType(null, "dust", null);
        WeatherType smoke = new WeatherType(null, "smoke", null);

        WeatherType fog = new WeatherType(null, "fog", null);

        WeatherType sand = new WeatherType(null, "sand", null);

        WeatherType ash = new WeatherType(null, "ash", null);

        userRepository.save(user1);
        songRepository.save(song1);

        // Set Genres
        clear.setGenre(pop);
        thunderstorm.setGenre(house);
        drizzle.setGenre(soulRnb);
        rain.setGenre(alternative);
        tornado.setGenre(electronic);
        squall.setGenre(electronic);
        clouds.setGenre(singerSongwriter);
        snow.setGenre(dance);
        mist.setGenre(dance);
        haze.setGenre(rock);
        dust.setGenre(rock);
        smoke.setGenre(rock);
        fog.setGenre(country);
        sand.setGenre(electronic);
        ash.setGenre(rock);

        // Weather
        weatherTypeRepository.save(clear);
        weatherTypeRepository.save(ash);
        weatherTypeRepository.save(squall);
        weatherTypeRepository.save(snow);
        weatherTypeRepository.save(smoke);
        weatherTypeRepository.save(fog);
        weatherTypeRepository.save(haze);
        weatherTypeRepository.save(clouds);
        weatherTypeRepository.save(sand);
        weatherTypeRepository.save(dust);
        weatherTypeRepository.save(mist);
        weatherTypeRepository.save(tornado);
        weatherTypeRepository.save(drizzle);
        weatherTypeRepository.save(thunderstorm);
    }
}
