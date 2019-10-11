package poc.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.domain.Response;
import poc.springboot.service.AppsStatusService;

@RestController
@Slf4j
public class AppsStatusController {
	@Autowired
	private AppsStatusService ass;

	@RequestMapping(method = RequestMethod.GET, path = "/apps-status")
	public Response appsStatus() {
		log.debug("appsStatus service");

		return ass.callBash();
	}
}
