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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.SongRepository;
import com.revature.data.UserRepository;
import com.revature.exceptions.AuthenticationException;
import com.revature.models.Song;
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

	@Autowired
	Optional<User> user;

	ObjectMapper mapper = new ObjectMapper();

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User deleteSong(User u) {
		
		u.getSongs().clear();
		
		return userRepo.save(u);

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public User register(User u) {

		return userRepo.save(u);

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public User add(User u) {

		if (u.getSongs() != null) {
			for (Song s : u.getSongs()) {

				if (songRepo.findBySongId(s.getSongId()) != null) {
					System.out.println("hi");
					s.setId(songRepo.findBySongId(s.getSongId()).getId());
				}
				songRepo.save(s);
			}
		}
		return userRepo.save(u);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void remove(User u) {
		
		userRepo.delete(u);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Optional<User> getByUsername(User u) {

		user = userRepo.findByUsername(u.getUsername());
		
		if (!user.isPresent()) {
			System.out.println("bad");
		} else if (user.get().getPassword().equals(u.getPassword())) {
			return user;
		}
		return null;
	}


}


