package com.revature.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.UserRepository;
import com.revature.models.User;

@Service
public class UserService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepo;

	@Transactional(readOnly = true)
	public Set<User> findAll() {

		return userRepo.findAll().stream().collect(Collectors.toSet());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public User add(User u) {

		if (u.getUsername() != null) {
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

	@Transactional(readOnly = true)
	public User login(User user) {

		if (user.getUsername() == null) {
			log.warn("Username cannot be <= 0. Username passed was: {}", user.getUsername());

			return null;

		} else if (user.getUsername().equals(user.getUsername())) {

			return userRepo.login(user);

		}
		return userRepo.login(user);
	}

}

// if user exists and password matches return user
// getbyusername
// if username and password != null
// send back the entire user object
