package ru.netology.authorizationservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.authorizationservice.controller.AuthorizationController;
import ru.netology.authorizationservice.repository.UserRepository;
import ru.netology.authorizationservice.service.AuthorizationService;

@Configuration
public class JavaConfig {
    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Bean
    public AuthorizationService authorizationService(UserRepository userRepository) {
        return new AuthorizationService(userRepository);
    }

    @Bean
    public AuthorizationController authorizationController(AuthorizationService authorizationService) {
        return new AuthorizationController(authorizationService);
    }
}
