package poc.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class HelloServiceMockTest {

	@MockBean
	private HelloService hs;

	@Test
	public void getHello() throws Exception {
		when(hs.hello()).thenReturn("Hello Mock");
		// given(this.hs.hello()).willReturn("Hello Mock");
		assertEquals("Hello Mock", hs.hello());
	}
}
