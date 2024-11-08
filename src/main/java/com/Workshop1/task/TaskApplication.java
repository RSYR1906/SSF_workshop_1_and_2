package com.Workshop1.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TaskApplication.class);
        ConfigurableApplicationContext context = app.run(args);

        // Programmatically read the port
        ConfigurableEnvironment environment = context.getEnvironment();
        String port = environment.getProperty("server.port");
        System.out.println("App is running on port: " + port);
    }
}
