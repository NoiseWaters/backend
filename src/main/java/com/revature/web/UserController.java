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

import com.revature.models.User;
import com.revature.service.UserService;

@RestController
@RequestMapping("/users") // all functionality is available at http://localhost:5000/api/users...
@CrossOrigin(origins = "*", allowedHeaders = "*") // allows this usercontroller to be hit by other resources
public class UserController {

	@Autowired
	private UserService userServ;

//	@PutMapping("/login")
//	public ResponseEntity<User> login(@RequestBody User user) {
//		
//		return ResponseEntity.ok(userServ.login(user));
//		
//	}

	@GetMapping
	public ResponseEntity<Set<User>> getAll() {

		return ResponseEntity.ok(userServ.findAll());

	}

	@PostMapping("/add")
	public ResponseEntity<User> addUser(@Valid @RequestBody User u) {

		return ResponseEntity.ok(userServ.add(u));

	}

	@GetMapping("/find/{username}")
	public ResponseEntity<Optional<User>> findUserByUsername(@PathVariable("username") String username) {

		return ResponseEntity.ok(userServ.getByUsername(username));
	}

	@DeleteMapping("/{id}")
	public void removeUser(@PathVariable("id") int id) {

		userServ.remove(id);
	}
}
