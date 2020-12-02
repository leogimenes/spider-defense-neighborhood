package spiderdefenseneighborhood.sdnweb.snmptranslator;

import java.util.ArrayList;
import java.util.List;

import spiderdefenseneighborhood.sdnweb.model.Disco;

public class TableInterpreter {
	private static List<Disco> listDisk;
	
	public static List<Disco> clearDisk(SnmpToJavaTable table){
		listDisk = new ArrayList<Disco>();
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

	public static List<Disco> getListDisk() {
		return listDisk;
	}

}
