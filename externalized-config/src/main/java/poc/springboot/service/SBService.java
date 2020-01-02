package poc.springboot.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SBService {

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
	}
}
