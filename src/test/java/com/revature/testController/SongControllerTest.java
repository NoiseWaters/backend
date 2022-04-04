package com.revature.testController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.revature.web.SongController;

@SpringBootTest
@AutoConfigureMockMvc
public class SongControllerTest {

	@Autowired
	SongController songController; 

	@Test
	public void testSaveSong() {

		songController.addSong(); 
		
	}
	

}

