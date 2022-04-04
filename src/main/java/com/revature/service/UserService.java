package com.revature.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.SongRepository;
import com.revature.data.UserRepository;
import com.revature.exception.AuthenticationException;
import com.revature.models.Song;
import com.revature.models.User;

@Service
public class UserService {
	
/*
 * 	@Service

	public class UserService {
		@Autowired
		private UsersDao cdao;
		// @Autowired //Possibly needed, possibly breaking
		public UserService(UsersDao mockDao) {
			cdao = mockDao;
		}
 */
	private Logger log = LoggerFactory.getLogger(this.getClass());

	// Spring IoC container will inject the auto-generated Impl class of this interface
	@Autowired				
	private UserRepository userRepo; // as a dependency of this Service Class

	@Autowired
	private SongRepository songRepo;

	@Autowired
	Optional<User> user;

	ObjectMapper mapper = new ObjectMapper();
	

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public User deleteSong(User u) {
//		userRepo.save(u);
//		//user = userRepo.findByUsername(u.getUsername());
//
//		if (u.getSongs() != null) {
//			for (Song s : u.getSongs()) {
//				if (songRepo.findBysongId(s.getSongId()) != null) {
//					s.setId(songRepo.findBysongId(s.getSongId()).getId());
//					
//					
//				}
//			}
//		}
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

				if (songRepo.findBysongId(s.getSongId()) != null) {
					System.out.println("hi");
					s.setId(songRepo.findBysongId(s.getSongId()).getId());
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
			throw new AuthenticationException();
		} else if (user.get().getPassword().equals(u.getPassword())) {
			return user;
		}
		throw new AuthenticationException();
	}

}
