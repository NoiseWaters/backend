package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Song;
import com.revature.service.SongService;

@RestController
@RequestMapping("/songs")
@CrossOrigin(origins="*", allowedHeaders="*")
public class SongController {
	
	@Autowired
	private SongService songServ;
	
	
	
	@GetMapping
	public ResponseEntity<List<Song>> addSong() {
		
		return ResponseEntity.ok(songServ.saveSong());
	}

}
