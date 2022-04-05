package com.revature.UserServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.data.SongRepository;
import com.revature.data.UserRepository;
import com.revature.models.User;
import com.revature.service.SongService;
import com.revature.service.UserService;

@SpringBootTest
class UserServiceTest {

	@MockBean
	private SongRepository songRepo;

	@InjectMocks
	private SongService songService;

	@MockBean
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@Test
	public void registerUserSuccess() {
		User user = new User();
		user.setUsername("patrickstar");
		user.setPassword("bikini123");
		user.setEmail("patrick@mail.com");

		when(userRepository.save(any(User.class))).thenReturn(user);

		User savedUser = userRepository.save(user);
		assertThat(savedUser.getUsername()).isNotNull();
	}

	@Test
	public void removeUserSuccess() {

		User user = new User();
		userRepository.save(user);
		userRepository.deleteById(user.getId());
		Optional<User> optional = userRepository.findById(user.getId());
		assertEquals(Optional.empty(), optional);

	}

//	@Test
//    public void userExistsInDbSuccess() {
//        User user = new User();
//        user.setUsername("patrickstar");
//		user.setPassword("bikini123");
//		user.setEmail("patrick@mail.com");
//        List<User> userList = new ArrayList<>();
//        userList.add(user);
//
//        when(userRepository.findAll()).thenReturn(userList);
//
//        Optional<User> fetchedUsers = userService.getByUsername(user);
//        assertEquals(fetchedUsers.isPresent(), user);
//    }

	@Test
	public void getByUsernameTest() {

		User user1 = new User();
		user1.setUsername("patrickstar");
		user1.setPassword("bikini123");
		user1.setEmail("patrick@mail.com");
		
		
		Mockito.when(userRepository.findByUsername("patrickstar")).thenReturn(Optional.ofNullable(user1));
		assertEquals(userRepository.findByUsername("patrickstar").get(), user1);

	}

}
