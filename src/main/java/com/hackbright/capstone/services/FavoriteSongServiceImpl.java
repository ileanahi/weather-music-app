package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.FavoriteSongDto;
import com.hackbright.capstone.entities.FavoriteSong;
import com.hackbright.capstone.entities.User;
import com.hackbright.capstone.repositories.FavoriteSongRepository;
import com.hackbright.capstone.repositories.SongRepository;
import com.hackbright.capstone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoriteSongServiceImpl implements FavoriteSongService {
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FavoriteSongRepository favoriteSongRepository;

    @Transactional
    public void addFavoriteSong(FavoriteSongDto favoriteSongDto, Long userId, Long songId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Song> songOptional = songRepository.findById(songId);
        FavoriteSong favoriteSong = new FavoriteSong(favoriteSongDto);
        userOptional.ifPresent(favoriteSong::setUser);
        songOptional.ifPresent(favoriteSong::setSong);
        favoriteSongRepository.saveAndFlush(favoriteSong);
    }

    @Transactional
    public void deleteFavoriteSongById(Long favoriteSongId) {
        Optional<FavoriteSong> favoriteSongOptional = favoriteSongRepository.findById(favoriteSongId);
        favoriteSongOptional.ifPresent(favoriteSong -> favoriteSongRepository.delete(favoriteSong));
    }

    @Override
    @Transactional
    public List<FavoriteSongDto> getAllFavoriteSongsByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<FavoriteSong> favoriteSongList = favoriteSongRepository.findAllByUserEquals(userOptional.get());
            return favoriteSongList.stream().map(favoriteSong -> new FavoriteSongDto(favoriteSong)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public Optional<FavoriteSongDto> getFavoriteSongById(Long favoriteSongId) {
        Optional<FavoriteSong> favoriteSongOptional = favoriteSongRepository.findById(favoriteSongId);
        if (favoriteSongOptional.isPresent()) {
            return Optional.of(new FavoriteSongDto(favoriteSongOptional.get()));
        }
        return Optional.empty();
    }
}