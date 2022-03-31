package com.revature.data;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

	
	

}