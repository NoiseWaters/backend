package com.revature.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.PlaylistService;

@CrossOrigin
@RestController
public class PlaylistController {

	@Autowired
	private PlaylistService playServ;

	// PlaylistController
	@DeleteMapping("/delete")
	public void deleteSongFromPlaylist(@RequestParam int id, @RequestParam int songId) {
		playServ.deleteSongFromPlaylistById(id, songId);
	}

}
