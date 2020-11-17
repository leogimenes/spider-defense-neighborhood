package spiderdefenseneighborhood.sdnweb.immutable;

import java.util.*;

//Classe com atributos privados e finais, sem setters, "imutavel"
//Os getters criam "Deep Copy" do objeto para que o objeto em si não possa ser acessado
//ver teste para instanciação do objeto imutavel

public final class ImmutablePassword {
	private final int id;
	private final String password;
	private final Map<String,String> hashMap;
	
	
	public ImmutablePassword(int id, String password, Map<String, String> hashMap) {
		
		this.id = id;
		
		this.password = password;
		
		Map<String,String> tempMap = new HashMap<>();
		for (Map.Entry<String,String> entry :
			hashMap.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		this.hashMap = tempMap;
	}
	
	public int getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Map<String,String> getHashMap() {
		Map<String,String> tempMap = new HashMap<>();
		for (Map.Entry<String,String> entry:
			this.hashMap.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		return tempMap;
	}	
}
