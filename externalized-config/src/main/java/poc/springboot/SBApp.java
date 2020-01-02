package poc.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.service.SBService;

@SpringBootApplication
@Slf4j
public class SBApp implements ApplicationRunner {

	@Autowired
	private SBService ss;

	public static void main(String[] args) {
		SpringApplication.run(SBApp.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.debug("run service");

		ss.main();
	}
}
