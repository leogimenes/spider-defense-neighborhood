package spiderdefenseneighborhood.sdnweb.snmptranslator;

import java.util.ArrayList;
import java.util.List;

import spiderdefenseneighborhood.sdnweb.model.Lldp;
import spiderdefenseneighborhood.sdnweb.model.Status;

public class SnmpToList extends SnmpToJava implements HostSelector, StatusSelector {

	public SnmpToList(String entry) {
		super(entry);
	}

	@Override
	public List<Lldp> getFormated() {
		String s = getEntry();
		s = s.replace('"', ',');
		s = s.replace("\n", "");
		List<Lldp> list = new ArrayList<Lldp>();
		String[] array = s.split(",");
		for(String i : array) {
			Lldp l = new Lldp("", i);
			if(!list.contains(l) && !i.isEmpty())
				list.add(l);
		}
		return list;
	}

	@Override
	public Status getStatus( Status status) {
		String s = getEntry().replace("\n", ",,");;
		String[] array = s.split(",,");

		if(array[0].equals("eth0")) {
			for(String k : array) {
				status.getIfName().add(k);
			}
		} else {
			for(int i = 0; i < status.getIfName().size(); i++) {
				status.getIfOperStatus().add(array[i]);
			}
		}
		return status;
	}

}
