package spiderdefenseneighborhood.sdnweb.snmptranslator;

public class SnmpToString extends SnmpToJava implements SelectorS {

	public SnmpToString(String entry) {
		super(entry);
	}

	@Override
	public String getFormated() {
		return getEntry().substring(getEntry().indexOf(':')+1, getEntry().length()-1);
	}

}
