package com.example.gsconsumingrest2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
public class GsConsumingRest2Application {
    private static final Logger log = Logger.getLogger(GsConsumingRest2Application.class.getName());


    public static void main(String[] args) {
        SpringApplication.run(GsConsumingRest2Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            var quote = restTemplate.getForObject(
                    "https://jsonplaceholder.typicode.com/todos/9", Response.class);
            assert quote != null;
            log.info(quote.toString());
        };
    }
}
