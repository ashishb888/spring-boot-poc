package poc.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AppsStatusApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppsStatusApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("run service");
	}

}
