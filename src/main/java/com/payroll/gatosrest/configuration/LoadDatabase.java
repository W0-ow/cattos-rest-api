package com.payroll.gatosrest.configuration;

import com.payroll.gatosrest.entity.Gato;
import com.payroll.gatosrest.repository.GatosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase
{
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(GatosRepository repository) {

        return args -> {
            log.info("Preloading" + repository.save(new Gato("Mr Whiskas", true)));
            log.info("Preloading" + repository.save(new Gato("Sr Manchas", true)));
            log.info("Preloading" + repository.save(new Gato("Kitty", true)));
            log.info("Preloading" + repository.save(new Gato("Mishi", true)));
            log.info("Preloading" + repository.save(new Gato("Dora", false)));
            log.info("Preloading" + repository.save(new Gato("Fuska", true)));
            log.info("Preloading" + repository.save(new Gato("Lua", false)));
            log.info("Preloading" + repository.save(new Gato("Aruba", false)));

        };
    }
}
