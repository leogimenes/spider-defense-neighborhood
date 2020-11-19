package spiderdefenseneighborhood.sdnweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import spiderdefenseneighborhood.sdnweb.model.Memoria;

@Controller
public class WebController {

//	@RequestMapping(value="/", params={"novoNumero"})
	
	@GetMapping(value = {"/", "/index.html"})
	public ModelAndView index(ModelAndView map) {
		map = new ModelAndView("teste");
		
		Memoria mem = new Memoria();
		Double numero = mem.getUsoMemoria();
		map.addObject("numero", numero);
		
		return map;
	}

	
	@GetMapping(value = {"/novoNumero"})
	public ModelAndView novoNumero(ModelAndView map) {
		map = new ModelAndView("teste");
		
		Memoria mem = new Memoria();
		Double numero = mem.getUsoMemoria();
		map.addObject("numero", numero);
		
		return map;
	}

//	@RequestMapping(value="/", params={"novoNumero"})
//	public String l(Memoria memoria){
//		
//		return"teste.html";
//	}
	

}
