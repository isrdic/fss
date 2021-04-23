package rs.srdic.fss.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("rs.srdic.fss.engine.repository")
@ComponentScan(basePackages = { "rs.srdic.fss.engine" })
//@EnableAutoConfiguration
@EntityScan("rs.srdic.fss.model")
//@PropertySource("classpath:application.properties")
public class EngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(EngineApplication.class, args);
    }


}
