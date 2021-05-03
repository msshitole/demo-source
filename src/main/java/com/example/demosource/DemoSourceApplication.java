package com.example.demosource;

import java.time.Duration;
import java.util.function.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class DemoSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSourceApplication.class, args);
    }

    @Bean
    public Supplier<Flux<String>> emit() {
        return () -> Flux.interval(Duration.ofSeconds(1L))
            .map(aLong -> "abc "+aLong)
            .log();
    }

}
