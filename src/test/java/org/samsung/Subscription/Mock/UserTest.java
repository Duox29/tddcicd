package org.samsung.Subscription.Mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.samsung.Subscription.User;
import org.samsung.Subscription.UserRepository;
import org.samsung.Subscription.UserService;

import java.util.Random;

import static org.mockito.Mockito.*;

public class UserTest {
    @Test
    public void testUserGet() {
        UserRepository mockRepository = Mockito.mock(UserRepository.class);
        when(mockRepository.findByEmail("duox@gmail.com")).thenReturn(new User(1,"DUOX","duox@gmail.com"));

        UserService service = new UserService(mockRepository);
        User result = service.findByEmail("duox@gmail.com");

        //verify
        Assertions.assertNotNull(result);
        Assertions.assertEquals("duox@gmail.com", result.getEmail());
        verify(mockRepository, times(1)).findByEmail("duox@gmail.com");
    }
    @Test
    public void testUserReg() {
        UserRepository mockRepository = Mockito.mock(UserRepository.class);
        when(mockRepository.findByEmail("duox@gmail.com")).thenReturn(null);

        when(mockRepository.save(any(User.class))).thenAnswer(i -> i.getArgument(0));
        UserService service = new UserService(mockRepository);
        User u = service.userRegister("DUOX","duox@gmail.com");
        Assertions.assertNotNull(u);
        Assertions.assertEquals("DUOX", u.getName());

        verify(mockRepository,times(1)).findByEmail("duox@gmail.com");
        verify(mockRepository,times(1)).save(any(User.class));
    }

    @Test
    public void testUserRegDuplicate() {
        UserRepository mockRepository = Mockito.mock(UserRepository.class);
        when(mockRepository.findByEmail("duox@gmail.com")).thenReturn(new User(new Random().nextInt(),"DUOX","duox@gmail.com"));
        UserService service = new UserService(mockRepository);

        Assertions.assertThrows(IllegalArgumentException.class, () -> service.userRegister("DUOX","duox@gmail.com"));
        verify(mockRepository,times(1)).findByEmail("duox@gmail.com");
        verify(mockRepository,times(0)).save(any(User.class));
    }
}
