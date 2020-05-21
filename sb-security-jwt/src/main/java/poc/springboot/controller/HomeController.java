package poc.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/hello")
	public String home() {
		return "Hello there";
	}

	@RequestMapping(path = "/authenticate", method = RequestMethod.POST)
	public String user() {
		return "<h1>Welcome user</h1>";
	}

}
