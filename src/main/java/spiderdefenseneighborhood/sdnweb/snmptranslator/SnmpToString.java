package spiderdefenseneighborhood.sdnweb.snmptranslator;

public class SnmpToString extends SnmpToJava implements SelectorS {

	public SnmpToString(String entry) {
		super(entry);
	}

	@Override
	public String getFormated() {
		String s = getEntry().replace(" ", "");
		return s.substring(s.indexOf(':'), s.length()-1);
	}

}
