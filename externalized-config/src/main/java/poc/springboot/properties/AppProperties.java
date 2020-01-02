package poc.springboot.properties;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppProperties {
	private Map<String, String> random;
}
