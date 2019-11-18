package poc.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.properties.AppProperties;

@Service
@Slf4j
public class ConfigService {

	@Autowired
	private AppProperties ap;

	private void start() {
		log.debug("start service");

		log.debug("k1: " + ap.getProps().get("k1"));
		log.debug("k2: " + ap.getProps().get("k2"));
	}

	public void main() {
		log.debug("main service");

		start();
	}
}
