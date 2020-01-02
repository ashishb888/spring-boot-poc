package poc.springboot.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.properties.AppProperties;

@Service
@Slf4j
public class SBService {

	@Autowired
	private AppProperties ap;

	private void start() {
		log.debug("start service");

		log.debug("random: " + ap.getRandom());
	}

	@PostConstruct
	private void pc() {
		log.debug("pc service");
	}

	@PreDestroy
	private void pd() {
		log.debug("pd service");
	}

	public void main() {
		log.debug("main service");

		start();
	}
}
