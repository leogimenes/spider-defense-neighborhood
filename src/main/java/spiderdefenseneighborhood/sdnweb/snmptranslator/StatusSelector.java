package spiderdefenseneighborhood.sdnweb.snmptranslator;

import spiderdefenseneighborhood.sdnweb.model.Status;

public interface StatusSelector {
	Status getStatus(Status status);
}
