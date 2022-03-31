package com.revature.data;

import org.springframework.context.annotation.ComponentScan;

public interface PlaylistRepository {

	// Song Repository
	void deleteByTwoID(int id, int songId);
	
}
