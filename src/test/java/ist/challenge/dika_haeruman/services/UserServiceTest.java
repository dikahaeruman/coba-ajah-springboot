package ist.challenge.dika_haeruman.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@PropertySource("application-test.properties")
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void getAllUser_ShouldReturn2Users_WhenThereIs2UsersOnDatabase() {

    }

    @Test
    public void createUser_ShouldSuccessfullyCreate1User_WhenInputValidUser() {
        Assert.assertEquals(1, userService.getUser().size());
    }
}
