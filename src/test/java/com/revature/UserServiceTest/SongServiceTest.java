package com.revature.UserServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.data.SongRepository;
import com.revature.data.UserRepository;
import com.revature.models.Song;
import com.revature.service.SongService;
import com.revature.service.UserService;

@SpringBootTest
public class SongServiceTest {

	@MockBean
	private SongRepository songRepo;

	@InjectMocks
	private SongService songService;

	@MockBean
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;
	
	

	@Test
	public void saveSongSuccess() {
		Song song = new Song();
		song.setId(1);
		song.setSongName("Hells Bells");
		song.setArtistName("ACDC");

		when(songRepo.save(song)).thenReturn(song);

		Song savedSong = songRepo.save(song);
		assertThat(savedSong.getId()).isNotNull();
	}

//	@Test
//	public void removeSongSuccess() {
//		Song song = new Song();
//		song.setId(1);
//		song.setSongName("Hells Bells");
//		song.setArtistName("ACDC");
//
//		when(songRepo.save(song)).thenReturn(song);
//
//		Optional<Long> savedSong = songRepo.deleteById(1);
//		assertEquals(savedSong.get(), 0);
//	}

}
