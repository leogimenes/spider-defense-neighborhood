package spiderdefenseneighborhood.sdnweb.snmptranslator;

import java.util.ArrayList;
import java.util.List;

import spiderdefenseneighborhood.sdnweb.model.Disco;

public class TableInterpreter {
	private static List<Disco> lista = new ArrayList<Disco>();
	
	public static List<Disco> clearDisk(SnmpToJavaTable table){
		
		for(int i = 0; i < table.getTable().size(); i++) {
			Disco disco = new Disco();
			getLista().add(disco);
			getLista().get(i).setPartition((table.getTable().get(i).get(2)));
			Long j = Long.parseLong(table.getTable().get(i).get(4)) *4096;
			Long j2 = Long.parseLong(table.getTable().get(i).get(5)) * 4096;
			getLista().get(i).setDiscoUsado(""+j2);
			getLista().get(i).setDiscoLivre(""+(j-j2));
		}
		return getLista();
	}

	public static List<Disco> getLista() {
		return lista;
	}

}
