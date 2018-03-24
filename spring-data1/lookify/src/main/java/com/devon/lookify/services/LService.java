package com.devon.lookify.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.devon.lookify.models.Song;
import com.devon.lookify.repositories.LRepo;

@Service
public class LService {
	private LRepo lRepo;
	public LService(LRepo lRepo) {
		this.lRepo = lRepo;
	}
		
	public ArrayList<Song> allSongs(){
		return lRepo.findAll();
	}
	public void addSong(Song song) {
		lRepo.save(song);
	}
	public Song findSongById(long id) {
		
        return lRepo.findById(id).orElse(null);
    }
	public void deleteSong(long id) {
		lRepo.deleteById(id);
	}
	public ArrayList<Song> songArtist(String artist){
		return lRepo.findByArtistContaining(artist);
	}
	public ArrayList<Song> topTen(){
		return lRepo.findFirst10ByOrderByRatingDesc();
	}
}
