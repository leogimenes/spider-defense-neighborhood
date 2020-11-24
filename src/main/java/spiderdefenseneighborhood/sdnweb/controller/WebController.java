package spiderdefenseneighborhood.sdnweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spiderdefenseneighborhood.sdnweb.model.Memoria;

@Controller
public class WebController {
	
	@GetMapping(value = {"/", "/dashboard"})
	public ModelAndView index(@RequestParam(value="hostName",defaultValue = "oob-server") String host,ModelAndView map) {
		map = new ModelAndView("dashboard");
		map.addObject("hostName", host);
		
		return map;
	}
	
	@GetMapping(value = {"/dispositivos"})
	public ModelAndView dispositivos (ModelAndView map) {
		map = new ModelAndView("dispositivos");
		
		return map;
	}

}
