package com.revature.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.revature.data.PlaylistRepository;

@Service
public class PlaylistService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private PlaylistRepository playRepo; 

	// SongService
	public void deleteSongFromPlaylistById(int id, int songId) {

		try {
			playRepo.deleteByTwoID(id, songId);
		} catch (Exception e) {
			log.error("User or Song Id invalid");
		}
	}

}
