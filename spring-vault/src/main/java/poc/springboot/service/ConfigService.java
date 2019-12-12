package poc.springboot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.properties.AppProperties;

@Service
@Slf4j
public class ConfigService {

	private void write(AppProperties ap) {
		log.debug("write service");

		VaultTemplate vaultTemplate = new VaultTemplate(new VaultEndpoint(),
				new TokenAuthentication("00000000-0000-0000-0000-000000000000"));

		Map<String, String> props = new HashMap<>();
		props.put("k1", "v1");
		props.put("k2", "v2");

		ap.setProps(props);

		vaultTemplate.write("secret/spring-vault", ap);

		VaultResponseSupport<AppProperties> response = vaultTemplate.read("secret/spring-vault", AppProperties.class);

		log.debug("props" + response.getData().getProps());

		vaultTemplate.delete("secret/spring-vault");
	}

	private void read(AppProperties ap) {
		log.debug("read service");

		log.debug("props: " + ap.getProps());
	}

	private void start() {
		log.debug("start service");

		AppProperties ap = new AppProperties();
		write(ap);
		read(ap);
	}

	public void main() {
		log.debug("main service");

		start();
	}
}
