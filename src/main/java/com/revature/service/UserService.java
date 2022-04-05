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

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired // Spring IoC container will inject the auto-generated Impl class of this
				// interface
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
	
	@Transactional(propagation=Propagation.REQUIRED) 
	public User removeSong(Song song) {
		
		Optional<User> u1 = userRepo.findByUsername(song.getArtistName());
		
		Song s1 = new Song();
		for(Song s : u1.get().getSongs()) {
			if((song.getId()) == (s.getId())) {
				System.out.println("I FOUND THE ONE ===============================");
				System.out.println(song);
				System.out.println(s);
				s1 = s;
				song.setArtistName(s.getArtistName());
				break;
			}
		}
		u1.get().getSongs().remove(song);
		return userRepo.save(u1.get());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public User add(User u) {
		
//		System.out.println("\n\n\n\n\n THIS RAN ");
		Optional<User> u1 = userRepo.findByUsername(u.getUsername());
		//System.out.println(u1.get().getSongs().add);
		
		//u1.get().setSongs(u1.get().getSongs().add(u.getSongs()));
		if (u.getSongs() != null) {
			for (Song s : u.getSongs()) {
				
				u1.get().getSongs().add(s);
				u1.get().setSongs(u1.get().getSongs());
				
				
				songRepo.save(s);
				
//				if (songRepo.findBysongId(s.getSongId()) != null) {
//					//s.setId(songRepo.findBysongId(s.getSongId()).getId());
//				}else{
//					songRepo.save(s);
//				}
			}
		}
		return userRepo.save(u1.get());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Optional<User> remove(User u) {

		return userRepo.deleteByUsername(u.getUsername());
		
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Optional<User> getByUsernameNoPwdCheck(User u) {

		return userRepo.findByUsername(u.getUsername());
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Optional<User> getByUsername(User u) {

		user = userRepo.findByUsername(u.getUsername());

		if (!user.isPresent()) {
			System.out.println("cannot find");
			throw new AuthenticationException();
		} else if (user.get().getPassword().equals(u.getPassword())) {
			return user;
		}
		throw new AuthenticationException();
	}

}