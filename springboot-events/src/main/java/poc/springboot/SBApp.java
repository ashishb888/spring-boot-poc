package poc.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.listener.ApplicationContextInitializedEventListener;
import poc.springboot.listener.ApplicationEnvironmentPreparedEventListener;
import poc.springboot.listener.ApplicationPreparedEventListener;
import poc.springboot.listener.ApplicationStartingEventListener;

@SpringBootApplication
@Slf4j
public class SBApp implements CommandLineRunner {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SBApp.class)
				.listeners(new ApplicationStartingEventListener(), new ApplicationEnvironmentPreparedEventListener(),
						new ApplicationContextInitializedEventListener(), new ApplicationPreparedEventListener())
				.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.debug("run service");
	}

}
