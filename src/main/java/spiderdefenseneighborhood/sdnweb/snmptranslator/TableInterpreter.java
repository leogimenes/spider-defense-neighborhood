package spiderdefenseneighborhood.sdnweb.snmptranslator;

import java.util.ArrayList;
import java.util.List;

public class TableInterpreter {
	
	public static List<List<String>> clearDisk(SnmpToJavaTable table){
		List<List<String>> list = new ArrayList<List<String>>();
		
		for(int i = 0; i < table.getTable().size(); i++) {
			list.add(new ArrayList<>());
			list.get(i).add(table.getTable().get(i).get(2));
			Long j = Long.parseLong(table.getTable().get(i).get(4)) *4096;
			Long j2 = Long.parseLong(table.getTable().get(i).get(5)) * 4096;
			list.get(i).add(""+j2);
			list.get(i).add(""+(j-j2));
		}
		System.out.println(list.toString());
		
		
		return null;
	}

}
