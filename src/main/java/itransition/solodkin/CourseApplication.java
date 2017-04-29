package itransition.solodkin;

import itransition.solodkin.model.Profile;
import itransition.solodkin.model.User;
import itransition.solodkin.model.UserRole;
import itransition.solodkin.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories
public class CourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class, args);
    }

    @Bean
    public CommandLineRunner bootstrap(UserRepository repository) {
        return (args) -> {
            repository.save(new User("solodkin@mail.ru",
                    new BCryptPasswordEncoder().encode("1111"), UserRole.ROLE_ADMIN, new Profile("Vlad")));
        };
    }
}
