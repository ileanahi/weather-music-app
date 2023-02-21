package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.SongDto;
import com.hackbright.capstone.entities.Song;
import com.hackbright.capstone.entities.User;
import com.hackbright.capstone.repositories.SongRepository;
import com.hackbright.capstone.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepository songRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<String> addSong(Long userId, SongDto songDto) {
        List<String> response = new ArrayList<>();
        Optional<User> user = userRepository.findById(userId);

        Song song = new Song(songDto);
        user.ifPresent(song::setUser);
        songRepository.saveAndFlush(song);
        response.add("Song added");
        return response;
    }

    @Override
    @Transactional
    public void deleteSongById(Long songId) {
        Optional<Song> songOptional = songRepository.findById(songId);
        songOptional.ifPresent(song -> songRepository.delete(song));
    }

    @Override
    public List<SongDto> getAllSongs() {
        return songRepository.findAll().stream().map(song -> new SongDto(song)).collect(Collectors.toList());
    }
}
