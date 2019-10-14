package poc.springboot.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.domain.Response;
import poc.springboot.properties.AppProperties;
import poc.springboot.utils.Constants;

@Service
@Slf4j
public class AppsStatusService {

	@Autowired
	private AppProperties ap;

	public Response<Map<String, Map<Object, Object>>> appsStatus() {
		log.debug("appsStatus service");

		ProcessBuilder pb = new ProcessBuilder();

		log.debug("commands: " + ap.getCommands());
		pb.command(ap.getCommands());

		try {
			Process process = pb.start();
			int status = process.waitFor();

			log.debug("status: " + status);

			if (status != 0)
				return new Response<Map<String, Map<Object, Object>>>(Constants.ERROR,
						Collections.singletonMap("SCRIPT_STATUS", "Script returned non-zero status code"), null);

			BufferedReader scriptReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			List<String> lines = scriptReader.lines().collect(Collectors.toList());
			log.debug("lines: " + lines);

			Map<String, Map<Object, Object>> map = lines.stream().map(e -> e.split("\\|"))
					.collect(Collectors.toMap(e -> e[0], e -> Arrays.stream(e[1].split("\\^")).map(d -> d.split("\\,"))
							.collect(Collectors.toMap(r -> r[0], r -> r[1]))));

			log.debug("map: " + map);

			return new Response<Map<String, Map<Object, Object>>>(Constants.SUCCESS, null, map);
		} catch (IOException | InterruptedException e) {
			log.error(e.getMessage(), e);

			return new Response<Map<String, Map<Object, Object>>>(Constants.ERROR,
					Collections.singletonMap("UNKNOWN", "Exception occured"), null);
		}
	}

	public void main() {
		log.info("main service");

		appsStatus();
	}
}
