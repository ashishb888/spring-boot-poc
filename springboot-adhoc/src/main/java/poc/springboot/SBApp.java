package poc.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.service.SBService;

@SpringBootApplication
@Slf4j
public class SBApp implements CommandLineRunner {

	@Autowired
	private SBService sbs;

	public static void main(String[] args) {
		SpringApplication.run(SBApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.debug("run service");

		sbs.main();
	}
}
