package poc.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello there";
	}
	
	@GetMapping("/home")
	public String home() {
		return "Welcome home";
	}
}
