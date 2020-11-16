package spiderdefenseneighborhood.sdnweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping(value = {"/", "/index.html"})
	public String index() {
		return "xtreme-html/ltr/index.html";
	}

}
