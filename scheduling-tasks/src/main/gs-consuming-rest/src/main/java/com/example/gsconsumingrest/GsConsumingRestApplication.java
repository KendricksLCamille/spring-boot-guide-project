package com.example.gsconsumingrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
public class GsConsumingRestApplication {

    private static final Logger log = Logger.getLogger(GsConsumingRestApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(GsConsumingRestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner run(RestTemplate restTemplate) {
        int i = 10;
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "https://jsonplaceholder.typicode.com/todos/9", Quote.class);
            assert quote != null;
            log.info(quote.toString());
        };
    }
}
