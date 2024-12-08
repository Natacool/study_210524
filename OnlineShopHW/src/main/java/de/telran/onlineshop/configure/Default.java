package de.telran.onlineshop.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class Default {

    @Bean(name = "random1")
    public Random takeRandom1() {
        return new Random(10);
    }

    @Bean(name = "random2")
    public Random takeRandom2() {
        return new Random(10);
    }


}
