package com.revature.web;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
<<<<<<< Updated upstream
=======
import org.springframework.web.bind.annotation.CrossOrigin;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< Updated upstream
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
=======
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.service.UserService;

@RestController
@RequestMapping("/users") // all functionality is available at http://localhost:5000/api/users...
<<<<<<< Updated upstream
=======
@CrossOrigin(origins="4200", allowedHeaders="*") // allows this userController to be hit by the front end S3
>>>>>>> Stashed changes
public class UserController {

	@Autowired // inject the service dependency into our controller class
	private UserService userServ; 
	
	// when a client sends a GET request to http://localhost:5000/api/users, they retrieve all users
	@GetMapping
	public ResponseEntity<Set<User>> getAll() {
		
<<<<<<< Updated upstream
		// Returning a ResponseEntity object alllows you to edit parts of the HTTP response like the status
=======
		// Returning a ResponseEntity object allows you to edit parts of the HTTP response like the status
>>>>>>> Stashed changes
		return ResponseEntity.ok(userServ.findAll());
		
	}
	
	// to add a User, accept a POST request, and return the added User object
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@Valid @RequestBody User u) { // @Valid ensures that the user object accepted
																	  // abides by the Validations we set up on its properties
		
		return ResponseEntity.ok(userServ.add(u));
		// what happens if a user tries to add a malformed JSON object????
		// we will use power of AOP to intercept the response that's sent back so the user/client
		// knows how to fix it.
	}
	
	// Find a user by their id
	@GetMapping("/{id}") // allows the client to send the request http://localhost:5000/api/users/2
	public ResponseEntity<User> findUserById(@PathVariable("id") int id) {
	
		return ResponseEntity.ok(userServ.getById(id));
	}
	
	// Find a user by their username
	
	// allows the client to send the request http://localhost:5000/api/users/johndoe
	@GetMapping("/find/{username}") // allows the client to send the request http://localhost:5000/api/users/2
	public ResponseEntity<User> findUserByUsername(@PathVariable("username") String username) {
	
		return ResponseEntity.ok(userServ.getByUsername(username));
	}
	
<<<<<<< Updated upstream
=======
//	@PutMapping("/users")
//	public User	updateUser(@Valid @RequestBody User u) {
//		return userServ.updateUser(u);
//		
//	}
	
	
>>>>>>> Stashed changes
	// Delete a user when they delete request to the url/id
	@DeleteMapping("/{id}")
	public void removeUser(@PathVariable("id") int id) {
		
		userServ.remove(id);
	}
<<<<<<< Updated upstream
}
=======
}






>>>>>>> Stashed changes
