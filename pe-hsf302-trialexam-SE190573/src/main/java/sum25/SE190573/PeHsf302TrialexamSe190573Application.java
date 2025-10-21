package sum25.SE190573;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "sum25.SE190573.repositories")
@EntityScan(basePackages = "sum25.SE190573")

public class PeHsf302TrialexamSe190573Application {

    public static void main(String[] args) {
        SpringApplication.run(PeHsf302TrialexamSe190573Application.class, args);
    }

}
