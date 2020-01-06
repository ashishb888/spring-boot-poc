package poc.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.service.WaitOnTouchService;

@SpringBootApplication
@Slf4j
public class WaitOnTouchApp implements CommandLineRunner {

	@Autowired
	private WaitOnTouchService wots;

	public static void main(String[] args) {
		SpringApplication.run(WaitOnTouchApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.debug("run service");

		wots.main();
	}

}
