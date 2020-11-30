package spiderdefenseneighborhood.sdnweb.snmptranslator;

public abstract class SnmpToJava {
	private String entry;
	
	public SnmpToJava(String entry) {
		this.entry = entry;
	}
	
	public String getEntry() {
		return entry;
	}
}
