package com.ensolversapp.appens.taskConfig;

import com.ensolversapp.appens.Repository.TaskRepo;
import com.ensolversapp.appens.model.Task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class taskConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            TaskRepo taskRepo){
        return args -> {
            Task first = new Task(
                    "Read 20 pages of Relaciones del trabajo"
            );
            Task second = new Task(
                    "Do exercise"
            );
            Task third = new Task(
                    "Go to grocery store"
            );
            Task fourth = new Task(
                    "Get christmas presents"
            );

            taskRepo.saveAll(
                    List.of(first,second,third,fourth)
            );

        };
    }

}
