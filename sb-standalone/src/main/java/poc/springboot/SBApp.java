package poc.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.service.HelloService;

@Slf4j
@SpringBootApplication
public class SBApp {

	@Autowired
	HelloService hs;

	public static void main(String[] args) {
		SpringApplication.run(SBApp.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			String[] beans = ac.getBeanDefinitionNames();

//			Arrays.stream(beans).sorted().forEach(r -> {
//				log.debug(r);
//			});

			log.debug("hs: " + hs.hello());
		};
	}

}
