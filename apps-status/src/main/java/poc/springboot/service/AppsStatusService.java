package poc.springboot.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppsStatusService {

	private void callBash() {
		log.info("callBash service");
	}

	public void main() {
		log.info("main service");

		callBash();
	}
}
