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

		log.debug("props: " + ap.getProps());
	}

	public void main() {
		log.debug("main service");

		start();
	}
}
