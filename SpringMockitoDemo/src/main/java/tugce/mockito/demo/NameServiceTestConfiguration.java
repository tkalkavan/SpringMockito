package tugce.mockito.demo;

import org.mockito.Mockito;
import org.springframework.context.annotation.*;
import tugce.service.NameService;

//The @Profile annotation tells Spring to apply this configuration only when the “test” profile is active
@Profile("test")
@Configuration
@ComponentScan("tugce.service")
public class NameServiceTestConfiguration {

    // The @Primary annotation is there to make sure this instance is used instead of a real one for autowiring.
    @Bean
    @Primary
    public NameService nameService() {
        // The method itself creates and returns a Mockito mock of our NameService class.
        //r. Because of this, Spring autowires a real instance of the UserService class, but a mock of the NameService class.
        return Mockito.mock(NameService.class);
    }
}