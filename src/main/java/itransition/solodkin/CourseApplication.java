package itransition.solodkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner bootstrap(UserRepository repository) {
//        return (args) -> {
//            repository.save(new User("solodkin@mail.ru",
//                    new BCryptPasswordEncoder().encode("1111"), UserRole.ROLE_ADMIN, new Profile("Vlad")));
//        };
//    }
}
