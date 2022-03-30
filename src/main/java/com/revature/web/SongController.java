package com.revature.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Song;
import com.revature.models.User;
import com.revature.service.SongService;

@RestController
@RequestMapping("/songs")
public class SongController {
	
	@Autowired
	private SongService songServ;
		
	@PostMapping("/add")
	public ResponseEntity<Song> addSong(@Valid @RequestBody User u) {
		
		return ResponseEntity.ok(songServ.save(u));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Song> deleteSong(@PathVariable User u) {
		
		return ResponseEntity.ok(songServ.delete(u)); 	
	}

}










