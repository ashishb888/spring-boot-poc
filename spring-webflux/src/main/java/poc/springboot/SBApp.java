package poc.springboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.client.GreetingWebClient;

@SpringBootApplication
@Slf4j
public class SBApp implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SBApp.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.debug("run service");

		GreetingWebClient gwc = new GreetingWebClient();
		log.debug("gwc: " + gwc.getResult());
	}
}
