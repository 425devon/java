
package com.devon.lookify.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.devon.lookify.models.Song;

public interface LRepo extends CrudRepository<Song, Long> {
	ArrayList<Song> findAll();
	ArrayList<Song> findByArtistContaining(String artist);
	ArrayList<Song> findFirst10ByOrderByRatingDesc();
}
