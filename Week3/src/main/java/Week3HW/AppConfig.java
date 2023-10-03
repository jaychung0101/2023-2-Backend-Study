package Week3HW;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class AppConfig {
    @Bean
    public ClassA classA() {
        return new ClassA();
    }
}
