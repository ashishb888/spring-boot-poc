package poc.springboot.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServiceB extends AbstractService {

	public void start() {
		log.debug("start service");
		m1("ServiceB");

		log.debug("ServiceB: " + s);

		ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();

		timer.scheduleAtFixedRate(() -> {
			log.debug("ServiceB: " + s);
		}, 10, 10, TimeUnit.SECONDS);
	}

	public void main() {
		log.debug("main service");

		start();
	}
}
