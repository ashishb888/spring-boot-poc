package poc.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public String hello() {
		return "Hello SB!";
	}
}
