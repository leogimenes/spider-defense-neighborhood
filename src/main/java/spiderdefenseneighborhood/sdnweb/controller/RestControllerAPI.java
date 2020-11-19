package spiderdefenseneighborhood.sdnweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import spiderdefenseneighborhood.sdnweb.model.Memoria;

@RestController
public class RestControllerAPI {

	
	@GetMapping("/api/memoria")
    public Memoria buscaMemoria() {
		
		return new Memoria();
    }
}
