package spiderdefenseneighborhood.sdnweb.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memoria {
	
	
	@SuppressWarnings("unused")
	private Double usoMemoria;
	@SuppressWarnings("unused")
	private Integer hora;
	
	public Integer getHora() {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss");
        String formatDateTime = localDateTime.format(formatter);
		return Integer.parseInt(formatDateTime);
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public Double getUsoMemoria() {
		return Math.random();
	}

	public void setUsoMemoria(Double usoMemoria) {
		this.usoMemoria = usoMemoria;
	}
	
}
