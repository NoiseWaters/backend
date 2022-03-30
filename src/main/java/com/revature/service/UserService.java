package com.revature.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.UserRepository;
import com.revature.models.User;

@Service
public class UserService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired // Spring IoC container will inject the auto-generated Impl class of this interface
	private UserRepository userRepo; // as a dependency of this Service Class

	@Autowired Optional<User> user;
	
	ObjectMapper mapper = new ObjectMapper();

	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User add(User u) {
		
		return userRepo.save(u);

	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void remove(int id) {
		
		userRepo.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public Optional<User> getByUsername(User u) {
		
		user = userRepo.findByUsername(u.getUsername());
		if (user.isEmpty()) {
			System.out.println("bad");
		} else if (user.get().getPassword().equals(u.getPassword())) {
			return user;
		}
		return null;
	}
	
}
