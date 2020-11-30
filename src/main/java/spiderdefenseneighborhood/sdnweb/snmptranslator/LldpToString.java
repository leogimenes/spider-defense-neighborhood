package spiderdefenseneighborhood.sdnweb.snmptranslator;

import spiderdefenseneighborhood.sdnweb.model.Lldp;

public class LldpToString extends SnmpToJava implements LldpSelector {
	
	private Lldp lldp = new Lldp();

	public LldpToString(String entry) {
		super(entry);
	}
	
	@Override
	public Lldp getFormated() {
		//remove espaços
		if(!getEntry().isEmpty()) {
			String s = getEntry().replace(" ", "");
			
			//remove pular linhas
			s = s.replace("\n", ",,");
			//Seta porta lldp
			lldp.setPort(s.substring(s.indexOf(':')+1, s.indexOf(',')));
			
			//remove primeiro elemento
			s = s.substring(s.indexOf(",,")+1);
			
			//Seta host na porta
			lldp.setHost(s.substring(s.indexOf(':')+1, s.indexOf(",,")));
		}
		
		return lldp;
	}

}
