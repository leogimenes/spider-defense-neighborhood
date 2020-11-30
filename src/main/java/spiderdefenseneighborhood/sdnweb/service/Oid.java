package spiderdefenseneighborhood.sdnweb.service;

public class Oid {
	public static String MEMORIA_TOTAL = "memTotalReal.0";
	public static String MEMORIA_LIVRE = "memAvailReal.0";
	public static String INIFOCTETS = "ifInOctets.3";
	public static String IFOUTOCTETS = "ifOutOctets.3";
	public static String IFHCINOCTETS = ".1.3.6.1.2.1.31.1.1.1.6.";
	public static String IFNAME = "ifName | grep -e swp* -e eth0";
	public static String IFSTATUS = "ifOperStatus";
	public static String CPU_IDLE = "ssCpuIdle.0";
	public static String HR_STORAGE_TABLE = "1.3.6.1.2.1.25.2.3 | grep hrStorageFixed";
	public static String LLDP = "nlmLogVariableTable.1.8";
}
