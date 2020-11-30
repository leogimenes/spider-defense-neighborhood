package spiderdefenseneighborhood.sdnweb.model;

import java.util.List;

public class LldpWrapper {
	private List<String> fruits;
	
	
	public LldpWrapper(List<String> lldpList) {
		super();
		this.fruits = lldpList;
	}

	public List<String> getLldpList(){
		return fruits;
	}
	
	public void setLldpList(List<String> lldp) {
		this.fruits = lldp;
	}
}
