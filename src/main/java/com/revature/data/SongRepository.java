package com.revature.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.models.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

	//Song findBysongId(int id);
	
	Optional<Long> deleteById(int id);
	
	
//	@Query("delete from SONG as s where s.user_id = ?1 and s.music_id=?2")
//	void deleteByID(int id, int songId);
}