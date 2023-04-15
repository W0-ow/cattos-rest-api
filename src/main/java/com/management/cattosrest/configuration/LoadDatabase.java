package com.management.cattosrest.configuration;

import com.management.cattosrest.repository.CattoRepository;
import com.management.cattosrest.entity.Catto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CattoRepository repository) {

        return args -> {
            repository.save(new Catto("Mr Whiskas", true));
            repository.save(new Catto("Sr Manchas", true));
            repository.save(new Catto("Kitty", true));
            repository.save(new Catto("Mishi", true));
            repository.save(new Catto("Dora", false));
            repository.save(new Catto("Fuska", true));
            repository.save(new Catto("Lua", false));
            repository.save(new Catto("Aruba", false));
            // logs of preloaded cattos
            repository.findAll().forEach(gato -> log.info("Preloaded " + gato));

        };
    }
}
