package poc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "poc.springboot.repos")
public class SbSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbSecurityJpaApplication.class, args);
	}

}
