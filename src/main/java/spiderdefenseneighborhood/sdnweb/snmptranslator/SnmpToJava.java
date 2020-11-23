package spiderdefenseneighborhood.sdnweb.snmptranslator;

public abstract class SnmpToJava {
	private String type;
	private String entry;
	
	public SnmpToJava(String entry) {
		type = entry.substring(0, entry.indexOf(':'));
		this.entry = entry;
	}
	
	public String getType() {
		return type;
	}
	
	public String getEntry() {
		return entry;
	}
}
