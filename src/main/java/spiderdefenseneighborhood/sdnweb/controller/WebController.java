package spiderdefenseneighborhood.sdnweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import spiderdefenseneighborhood.sdnweb.model.Memoria;

@Controller
public class WebController {
	
	@GetMapping(value = {"/", "/index"})
	public ModelAndView index(ModelAndView map) {
		map = new ModelAndView("dashboard");
		
		return map;
	}
	
	@GetMapping(value = {"/dispositivos"})
	public ModelAndView dispositivos (ModelAndView map) {
		map = new ModelAndView("dispositivos");
		
		return map;
	}

}
