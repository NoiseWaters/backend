package com.revature.testService; 

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.revature.data.UserRepository;
import com.revature.models.User;
import com.revature.service.UserService;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = User.class, loader = AnnotationConfigContextLoader.class)
class UserServiceTest {
	@InjectMocks
	@Autowired
	private UserRepository mockDao;
	@Autowired
	private UserService uServ;
	@BeforeEach
	void initMock() {
		mockDao = Mockito.mock(UserRepository.class);
		uServ = new UserService();
	}
	@BeforeAll
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void getUserByIdSuccess() {
		User bob = new User();
		bob.setUsername("TestUsername");
		bob.setPassword("ThisisSecurePassword");
		bob.setEmail("SuperKool@email.com");
		bob.setUsername("First");
		bob.setId(1);
		System.out.println(bob);
		System.out.println(mockDao);
		Mockito.when(mockDao.getById(1)).thenReturn(bob);
		System.out.println("Succesfully made mockito");
		User recieved = uServ.add(bob);
		assertEquals(bob, recieved);
	}
	
	
	@Test
	public void userRegisterTest() {
		
		User user = new User(); 
		
		mockDao.save(user); 
		
	}
	
	
}














