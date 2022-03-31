package com.revature.web;

import java.util.Optional;
import java.util.Set;

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

import com.revature.models.User;
import com.revature.service.UserService;

@RestController
@RequestMapping("/users") // all functionality is available at http://localhost:5000/api/users...
public class UserController {

	@Autowired // inject the service dependency into our controller class
	private UserService userServ; 

	
	@PostMapping("/register")
	public ResponseEntity<User> register(@Valid @RequestBody User u) {
		
		return ResponseEntity.ok(userServ.register(u));
		
	}
	
	@PostMapping("/addsong")
	public ResponseEntity<User> add(@Valid @RequestBody User u) {
		
		return ResponseEntity.ok(userServ.add(u));		
	}
	
	@GetMapping("/find")
	public ResponseEntity<Optional<User>> login(@RequestBody User u) {
	
		return ResponseEntity.ok(userServ.getByUsername(u));
	}
	
	@DeleteMapping()
	public void removeUser(@RequestBody User u) {
		
		userServ.remove(u);
	}
	
	@DeleteMapping("/deletesong")
	public void deleteSong(@RequestBody User u) {
		
		userServ.deleteSong(u);
	}
}







