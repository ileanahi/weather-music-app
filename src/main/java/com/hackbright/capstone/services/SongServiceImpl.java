package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.SongDto;
import com.hackbright.capstone.entities.Song;
import com.hackbright.capstone.repositories.SongRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepository songRepository;

    @Override
    @Transactional
    public List<String> addSong(SongDto songDto, Long userId) {
        List<String> response = new ArrayList<>();
        Song song = new Song(songDto);
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


}
