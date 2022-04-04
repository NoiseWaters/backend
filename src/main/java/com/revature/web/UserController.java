package com.revature.web;

import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Song;
import com.revature.models.User;
import com.revature.service.UserService;

@RestController
@RequestMapping("/users") // all functionality is available at http://localhost:5000/api/users...
@CrossOrigin(origins="*", allowedHeaders="*")
public class UserController {

	@Autowired // inject the service dependency into our controller class
	private UserService userServ; 

	
	@PostMapping("/register")
	public ResponseEntity<User> register(@Valid @RequestBody User u) {
		
		return ResponseEntity.ok(userServ.register(u));
	}
	
	@PostMapping("/addsong")
	public ResponseEntity<User> add(@Valid @RequestBody User u) {
		//System.out.println(u);
		return ResponseEntity.ok(userServ.add(u));		
	}
	
	@PostMapping("/find")
	public ResponseEntity<Optional<User>> login(@Valid @RequestBody User u) {
		
		return ResponseEntity.ok(userServ.getByUsername(u));
	}
	
	
	@PostMapping("/findNoPwd")
	public ResponseEntity<Optional<User>> find(@Valid @RequestBody User u) {
		
		return ResponseEntity.ok(userServ.getByUsernameNoPwdCheck(u));
	}
	
	@PostMapping("/removeuser")
	public ResponseEntity<Optional<User>> removeUser(@Valid @RequestBody User u) {
		return ResponseEntity.ok(userServ.remove(u));
	}
	
	@PostMapping("/deletesong")
	public ResponseEntity<User> deleteSong(@Valid @RequestBody Song s) {
		
		//System.out.println(u);
		return ResponseEntity.ok(userServ.removeSong(s));
	}
}