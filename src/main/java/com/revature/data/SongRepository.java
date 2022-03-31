package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

	Song findBySongId(int id);
	
}