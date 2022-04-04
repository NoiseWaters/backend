package com.revature.testController; 

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.revature.data.UserRepository;
import com.revature.models.User;
import com.revature.web.UserController;
 
@ExtendWith(MockitoExtension.class)
public class UserControllerTest 
{
    @InjectMocks
    UserController employeeController;
     
    @Mock
    UserRepository userRepository;
     
    @Test
    public void testAddUser() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        when(userRepository.equals(any(User.class))).thenReturn(true);
         
        User user = new User("Lokesh", "Gupta", "howtodoinjava@gmail.com");
        ResponseEntity<User> responseEntity = employeeController.add(user);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }
     
//    @Test
//    public void testFindAll() 
//    {
//        // given
//        User employee1 = new User("Lokesh", "Gupta", "howtodoinjava@gmail.com");
//        User employee2 = new User("Alex", "Gussin", "example@gmail.com");
//        Users employees = new Users();
//        employees.setUserList(Arrays.asList(employee1, employee2));
// 
//        when(userRepository.saveAll(null)).thenReturn(employees);
// 
//        // when
//        Users result = ((Object) employeeController).getUsers();
// 
//        // then
//        assertThat(result.getUserList().size()).isEqualTo(2);
//         
//        assertThat(result.getUserList().get(0).getFirstName())
//                        .isEqualTo(employee1.getFirstName());
//         
//        assertThat(result.getUserList().get(1).getFirstName())
//                        .isEqualTo(employee2.getFirstName());
//    }
}



