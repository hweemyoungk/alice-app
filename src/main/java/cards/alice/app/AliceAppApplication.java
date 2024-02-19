package cards.alice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cards.alice"})
public class AliceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AliceAppApplication.class, args);
    }

}
