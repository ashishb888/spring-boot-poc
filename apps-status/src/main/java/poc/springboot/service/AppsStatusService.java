package poc.springboot.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.domain.Response;

@Service
@Slf4j
public class AppsStatusService {

	public Response callBash() {
		log.info("callBash service");

		ProcessBuilder pb = new ProcessBuilder();
		List<String> commands = new ArrayList<>(2);
		commands.add("/opt/ngs/ashishb/bash/status-all.sh");
		pb.command(commands);

		int status;
		Response resp = null;

		try {
			Process p = pb.start();

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			Map<String, String> map = reader.lines().map(e -> e.split("\\,"))
					.collect(Collectors.toMap(e -> e[0], e -> e[1]));
			log.info("map: " + map);

//			String line;
//			while ((line = reader.readLine()) != null) {
//				log.info("line: " + Arrays.toString(line.split("\\,")));
//				output.append(line + "\n");
//			}
//
//			log.info("output: " + output.toString());

			status = p.waitFor();
			log.info("status: " + status);

			resp = new Response("success", map);

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
