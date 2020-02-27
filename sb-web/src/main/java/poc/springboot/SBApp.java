package poc.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SBApp {

	public static void main(String[] args) {
		SpringApplication.run(SBApp.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			String[] beans = ac.getBeanDefinitionNames();

			Arrays.stream(beans).sorted().forEach(r -> {
				log.debug(r);
			});
		};
	}

}
