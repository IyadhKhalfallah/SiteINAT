package inatjunior.website;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo() {
        try {
            return (args) -> {
            };
        }
        catch (Exception ex){}

        return null;
    }
}
