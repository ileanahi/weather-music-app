package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.FavoriteSongDto;

import java.util.List;
import java.util.Optional;

public interface FavoriteSongService {
    List<FavoriteSongDto> getAllFavoriteSongsByUserId(Long userId);

    Optional<FavoriteSongDto> getFavoriteSongById(Long favoriteSongId);
}
