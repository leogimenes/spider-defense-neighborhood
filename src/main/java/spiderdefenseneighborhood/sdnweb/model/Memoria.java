package spiderdefenseneighborhood.sdnweb.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memoria {
	
	
	private Double usoMemoria;
	private String hora;
	
	public String getHora() {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = localDateTime.format(formatter);
		return formatDateTime;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Double getUsoMemoria() {
		return Math.random();
	}

	public void setUsoMemoria(Double usoMemoria) {
		this.usoMemoria = usoMemoria;
	}
	
}
