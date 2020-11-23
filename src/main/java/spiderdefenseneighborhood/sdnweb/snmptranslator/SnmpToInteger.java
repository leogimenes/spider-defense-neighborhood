package spiderdefenseneighborhood.sdnweb.snmptranslator;

public class SnmpToInteger extends SnmpToJava implements SelectorI {

	public SnmpToInteger(String entry) {
		super(entry);
	}

	@Override
	public Integer getFormated() {
		String s = getEntry().substring(getEntry().indexOf(':')+2, getEntry().indexOf('k')-1);
		return Integer.parseInt(s);
	}

}
