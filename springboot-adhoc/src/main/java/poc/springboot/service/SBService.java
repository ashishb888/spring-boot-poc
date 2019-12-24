package poc.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SBService {
	@Autowired
	private ServiceA sa;
	@Autowired
	private ServiceB sb;

	public void main() {
		log.debug("main service");

		sa.main();
		sb.main();
	}
}
