package poc.springboot.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.domain.Response;
import poc.springboot.properties.AppProperties;

@Service
@Slf4j
public class AppsStatusService {

	@Autowired
	private AppProperties ap;

	public Response<Map<String, String>> callBash() {
		log.info("callBash service");

		ProcessBuilder pb = new ProcessBuilder();

		log.info("commands: " + ap.getCommands());
		pb.command(ap.getCommands());

		int status;
		Response<Map<String, String>> resp = null;

		try {
			Process process = pb.start();
			status = process.waitFor();
			log.info("status: " + status);

			BufferedReader scriptReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			List<String> lines = scriptReader.lines().collect(Collectors.toList());
			log.info("lines: " + lines);

			Map<String, String> map = lines.stream().map(e -> e.split("\\,"))
					.collect(Collectors.toMap(e -> e[0], e -> e[1]));

			log.info("map: " + map);

			resp = new Response<Map<String, String>>("success", map);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}

		return resp;
	}

	public Response<Map<String, Map<Object, Object>>> callBashR() {
		log.info("callBashR service");

		ProcessBuilder pb = new ProcessBuilder();

		log.info("commands: " + ap.getCommands());
		pb.command(ap.getCommands());

		int status;
		Response<Map<String, Map<Object, Object>>> resp = null;

		try {
			Process process = pb.start();
			status = process.waitFor();
			log.info("status: " + status);

			BufferedReader scriptReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			List<String> lines = scriptReader.lines().collect(Collectors.toList());
			log.info("lines: " + lines);

			Map<String, Map<Object, Object>> map = lines.stream().map(e -> e.split("\\|"))
					.collect(Collectors.toMap(e -> e[0], e -> Arrays.stream(e[1].split("\\^")).map(d -> d.split("\\,"))
							.collect(Collectors.toMap(r -> r[0], r -> r[1]))));

			log.info("map: " + map);

			resp = new Response<Map<String, Map<Object, Object>>>("success", map);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}

		return resp;
	}

	public void main() {
		log.info("main service");

		callBash();
	}
}
