package poc.springboot.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.properties.AppProperties;

@Service
@Slf4j
public class WaitOnTouchService {

	@Autowired
	private AppProperties ap;

	public int touchFilesCount() {
		log.debug("touchFilesCount service");

		ProcessBuilder pb = new ProcessBuilder();

		log.debug("commands: " + ap.getCommands());
		pb.command(ap.getCommands());

		try {
			Process process = pb.start();
			int status = process.waitFor();

			log.debug("status: " + status);

			if (status != 0)
				throw new RuntimeException("Script returned " + status + " status code");

			BufferedReader scriptReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			return Integer.valueOf(scriptReader.readLine());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public void main() {
		log.debug("main service");

		try {
			int count = touchFilesCount();
			log.debug("count: " + count);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
}
