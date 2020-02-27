package poc.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceTest {

	@Autowired
	private HelloService hs;

	@Test
	public void getHello() throws Exception {

		assertEquals("Hello SB!", hs.hello());
	}
}
