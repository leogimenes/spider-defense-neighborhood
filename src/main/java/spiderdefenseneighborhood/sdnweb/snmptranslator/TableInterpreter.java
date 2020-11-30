package spiderdefenseneighborhood.sdnweb.snmptranslator;

import java.util.ArrayList;
import java.util.List;

import spiderdefenseneighborhood.sdnweb.model.Disco;
import spiderdefenseneighborhood.sdnweb.model.Status;

public class TableInterpreter {
	private static List<Disco> listDisk = new ArrayList<Disco>();
	private static List<Status> listNet = new ArrayList<Status>();
	
	public static List<Disco> clearDisk(SnmpToJavaTable table){
		
		for(int i = 0; i < table.getTable().size(); i++) {
			Disco disco = new Disco();
			getListDisk().add(disco);
			getListDisk().get(i).setPartition((table.getTable().get(i).get(2)));
			Long j = Long.parseLong(table.getTable().get(i).get(4)) *4096;
			Long j2 = Long.parseLong(table.getTable().get(i).get(5)) * 4096;
			getListDisk().get(i).setDiscoUsado(""+j2);
			getListDisk().get(i).setDiscoLivre(""+(j-j2));
		}
		return getListDisk();
	}
	
	public static List<Status> clearNet(SnmpToJavaTable table){
		System.out.println(table.getEntry().indexOf("ifName"));
		return getListNet();
	}

	public static List<Disco> getListDisk() {
		return listDisk;
	}

	public static List<Status> getListNet() {
		return listNet;
	}

}
