package tugce.mockito.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tugce.service.NameService;
import tugce.service.UserService;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.mockito.Mockito.mock;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication

public class UserServiceTest {


    @Autowired
    private UserService userService;

    @Autowired
    private NameService nameService;

    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {

        //Spring autowires a real instance of the UserService class, but a mock of the NameService class.
        Mockito.when(nameService.getUserName("SomeId")).thenReturn("Mock user name");

        String testName = userService.getUserName("SomeId");
        Assert.assertEquals("Mock user name", testName);

    }

    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrectMockAnnotation() {

        NameService nameService=mock(NameService.class);


        Mockito.when(nameService.getUserName("tugce")).thenReturn("Mock tugce user name");

        String testName = nameService.getUserName("tugce");

        Assert.assertEquals(nameService.getUserName("tugce"), testName);

    }
}