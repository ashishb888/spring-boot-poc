package poc.springboot.properties;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppProperties {
	private Map<String, String> props;
}
