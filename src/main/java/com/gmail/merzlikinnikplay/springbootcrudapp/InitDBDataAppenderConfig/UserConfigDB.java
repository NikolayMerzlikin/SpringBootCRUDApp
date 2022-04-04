package com.gmail.merzlikinnikplay.springbootcrudapp.InitDBDataAppenderConfig;

import com.gmail.merzlikinnikplay.springbootcrudapp.model.User;
import com.gmail.merzlikinnikplay.springbootcrudapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfigDB {

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
          userRepository.saveAll(List.of(
                  new User("Ivan", "Ivanov", 10),
                  new User("Petr" ,"Petrov", 20),
                  new User("Alex", "Alexandrov" ,30)
          ));
        };
    }
}
