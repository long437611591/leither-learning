package arm.sec.iot.test01.testUserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import arm.sec.iot.entity.User;
import arm.sec.iot.service.UserService;
import arm.sec.iot.service.impl.UserServiceIml;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserServiceIml.class})
public class UserServiceTest {

    @Mock
    private User user;

    @Test
    public void saveUser() throws Exception {
        
        String name  = "123";
        String pass = "123";

        User mockUser = mock(User.class);

        whenNew(User.class).withArguments(name,pass).thenReturn(user);
        doNothing().when(user).insert();
        

        UserServiceIml userService = new UserServiceIml();
        userService.saveUser(name,pass);

        verify(user,times(2)).insert();


    }
    
}