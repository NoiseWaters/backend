package com.revature.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.SongRepository;
import com.revature.data.UserRepository;
import com.revature.exceptions.AuthenticationException;
import com.revature.models.User;

@Service
public class UserService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SongRepository songRepo; 
	
	// calls on the DB (by way of the User Repository) to check the credentials of the user that's logging in
	public User authenticate(User user) {
			
		// asks the question: are you who you say you are and do you exist in the DB?
		User userInDb = userRepo.findByUsername(user.getUsername())
					.orElseThrow(AuthenticationException::new); // instantiate a new Authentication excpetion IF the username doesn't exists
			
		// test the password
		if (user.getPassword().equals(userInDb.getPassword())) {
				return userInDb;
			}
			
			throw new AuthenticationException();
		}

	@Transactional(readOnly = true)
	public Set<User> findAll() {

		return userRepo.findAll().stream().collect(Collectors.toSet());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public User add(User u) {

		if (u.getSongs() != null) {
			u.getSongs().forEach(songs -> songRepo.save(songs));
		}

		return userRepo.save(u);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(int id) {

		userRepo.deleteById(id);

	}

	@Transactional(readOnly = true)
	public Optional<User> getByUsername(String username) {

		if (username == "") {
			log.warn("Username cannot be <= 0. Id passed was: {}", username);
			return null;
		}

		return userRepo.findByUsername(username);
	}

	@Transactional(readOnly = true)
	public User getById(int id) {

		if (id <= 0) {
			log.warn("Id cannot be <= 0. Id passed was: {}", id);
			return null;
		} else {
			return userRepo.getById(id);
		}

	}

}


