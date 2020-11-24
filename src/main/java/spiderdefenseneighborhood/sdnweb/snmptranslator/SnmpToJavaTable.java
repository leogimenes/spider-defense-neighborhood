package spiderdefenseneighborhood.sdnweb.snmptranslator;

import java.util.ArrayList;
import java.util.List;

public class SnmpToJavaTable extends SnmpToJava implements TableSelector {
	private List<List<String>> table = new ArrayList<List<String>>();

	public SnmpToJavaTable(String entry) {
		super(entry);
		
//		Corrige tabulação para posterior formatação de tabela	 
		String interpreter = getEntry().replace("\n", ",,");
//		Formata linhas da tabela
		String [] array1 = interpreter.split(",,");
		
		for(int i=0; i < array1.length; i++) {
			this.table.add(new ArrayList<>());
//			Formata colunas da tabela
			String[] s = array1[i].split(",");			
			
			for(int j=0; j < s.length; j++) {
				this.table.get(i).add(s[j]);
			}
		}
	}

	@Override
	public List<List<String>> getFormated() {
		return getTable();
	}	

	public List<List<String>> getTable() {
		return table;
	}

	@Override
	public String toString() {
		return "SnmpToJavaTable2 [table=" + table + "]";
	}

}
