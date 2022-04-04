package com.revature.service;



import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.SongRepository;
import com.revature.models.Song;
import com.revature.models.User;

@Service
public class SongService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SongRepository songRepo;
	
	
	
	@Transactional(propagation=Propagation.REQUIRED) 
	public List<Song> saveSong() {
		
		
	//	u.getSongs().iterator().next().setOwners(u);
		return songRepo.findAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRED) 
	public Optional<Long> removeSong(int id) {
		
		
	//	u.getSongs().iterator().next().setOwners(u);
		return songRepo.deleteById(id);
	}
	
}
