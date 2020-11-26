package spiderdefenseneighborhood.sdnweb.snmptranslator;

public class SnmpToInteger2 extends SnmpToJava implements SelectorI {

	public SnmpToInteger2(String entry) {
		super(entry);
	}

	@Override
	public Integer getFormated() {
		String s = getEntry().substring(getEntry().indexOf(':')+2);
		System.out.print(s);
		System.out.println(Integer.parseInt(s));
		return Integer.parseInt(s);
	}

}
