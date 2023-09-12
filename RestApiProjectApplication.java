package com.BusManagementPrg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*@SpringBootApplication: A convenience annotation that combines @configuration
 * it enables component scanning within the package and its sub-packages.
 */

@SpringBootApplication // Indicates that this class is a Spring Boot application
public class RestApiProjectApplication {
    // This is the main method, which is the entry point of the application
    public static void main(String[] args) {
        SpringApplication.run(RestApiProjectApplication.class, args);
        // Launches the Spring Boot application and starts the embedded web server
    }
}
