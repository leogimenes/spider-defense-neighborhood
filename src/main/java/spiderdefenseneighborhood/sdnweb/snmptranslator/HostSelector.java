package spiderdefenseneighborhood.sdnweb.snmptranslator;

import java.util.List;

import spiderdefenseneighborhood.sdnweb.model.Lldp;

public interface HostSelector {
	List<Lldp> getFormated();
}
