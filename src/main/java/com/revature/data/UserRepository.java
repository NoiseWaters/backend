package com.revature.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository 
public interface UserRepository extends JpaRepository<User, Integer> { 

	Optional<User> findByUsername(String username); 
	
	
}
