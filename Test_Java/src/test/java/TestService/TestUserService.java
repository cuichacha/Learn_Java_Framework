package TestService;

import Service.UserService;
import org.junit.Test;

public class TestUserService {

    @Test
    public void testUserService() {
        UserService userService = new UserService();
        userService.findAll();
    }
}
