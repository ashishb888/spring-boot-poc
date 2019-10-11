package poc.springboot.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

	public Response callBash() {
		log.info("callBash service");

		ProcessBuilder pb = new ProcessBuilder();

		log.info("commands: " + ap.getCommands());
		pb.command(ap.getCommands());

		int status;
		Response resp = null;

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

			resp = new Response("success", map);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}

		return resp;
	}

	public Response callBashFile() {
		log.info("callBashFile service");

		String fileName = "/var/tmp/status-all/notest.txt";
		ProcessBuilder pb = new ProcessBuilder();

//		List<String> commands = new ArrayList<>(2);
//		commands.add("cd");
//		commands.add("/opt/ngs/ashishb/bash/apps-status");
//		commands.add("bash");
//		commands.add("apps-status-remote1.sh");
////		commands.add("./apps-status.sh");
//		commands.add(fileName);

		log.info("commands: " + ap.getCommands());
		pb.command(ap.getCommands());

		int status;
		Response resp = null;

		try {
			Process process = pb.start();

			BufferedReader scriptReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			List<String> lines = scriptReader.lines().collect(Collectors.toList());

			status = process.waitFor();
			log.info("status: " + status);

//			Path filePath = Paths.get(fileName);
//			BufferedReader reader = Files.newBufferedReader(filePath);
//
////			reader.lines().forEach(r -> {
////				log.info("r: " + r);
////			});
//
//			List<String> lines = reader.lines().collect(Collectors.toList());
//
//			lines.stream().forEach(r -> {
//				log.info("r: " + r);
//			});
//
//			Map<String, String> hostApps = lines.stream().map(e -> e.split("\\|"))
//					.collect(Collectors.toMap(e -> e[0], e -> e[1]));
//			log.info("hostApps: " + hostApps);
//
//			hostApps.forEach((k, v) -> {
//
//				Map<String, Map<String, String>> hostApps1 = new HashMap<>();
//
//				Map<String, String> apps = Arrays.asList(v.split("\\^")).stream().map(e -> e.split("\\,"))
//						.collect(Collectors.toMap(e -> e[0], e -> e[1]));
//
//				log.info("apps: " + apps);
//
//				hostApps1.put(k, apps);
//
//				log.info("hostApps1: " + hostApps1);
//			});
//
//			lines.stream().map(e -> e.split("\\|")).map(e -> e[1].split("\\^")).map(e -> e[2].split("\\,"))
//					.forEach(r -> {
//						log.info("r: " + Arrays.toString(r));
//					});
//
//			log.info("new map: " + reader.lines().map(e -> e.split("\\|")).map(e -> e[1].split("\\|"))
//					.collect(Collectors.groupingBy(e -> e[0], Collectors.toMap(e -> e[1], e -> e[2]))));
//
//			resp = new Response("success", null);
//
//			// Files.delete(filePath);

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
