package poc.springboot.domain;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
	private String status;
	private Map<String, String> messages;
	private T data;
}
