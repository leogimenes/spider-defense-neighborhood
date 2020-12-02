package spiderdefenseneighborhood.sdnweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jcraft.jsch.Session;

import spiderdefenseneighborhood.sdnweb.model.Disco;
import spiderdefenseneighborhood.sdnweb.model.Lldp;
import spiderdefenseneighborhood.sdnweb.model.Rede;
import spiderdefenseneighborhood.sdnweb.model.Status;
import spiderdefenseneighborhood.sdnweb.service.NewChannel;
import spiderdefenseneighborhood.sdnweb.service.Oid;
import spiderdefenseneighborhood.sdnweb.service.SessionFactory;
import spiderdefenseneighborhood.sdnweb.snmptranslator.HostSelector;
import spiderdefenseneighborhood.sdnweb.snmptranslator.LldpSelector;
import spiderdefenseneighborhood.sdnweb.snmptranslator.LldpToString;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SelectorI;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SelectorS;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SnmpToInteger;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SnmpToJava;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SnmpToJavaTable;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SnmpToList;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SnmpToString;
import spiderdefenseneighborhood.sdnweb.snmptranslator.StatusSelector;
import spiderdefenseneighborhood.sdnweb.snmptranslator.TableInterpreter;

@RestController
public class RestControllerAPI {
	@SuppressWarnings("unused")
	private Session session = SessionFactory.getInstance();


	@GetMapping("/api/memoria")
	public Integer buscaMemoria(@RequestParam(value="hostName", required = false) String host) {

		try {
			SnmpToJava stj = new SnmpToInteger(NewChannel.snmpGet(SessionFactory.getInstance(), host, Oid.MEMORIA_LIVRE));
			SnmpToJava stj2 = new SnmpToInteger(NewChannel.snmpGet(SessionFactory.getInstance(), host, Oid.MEMORIA_TOTAL));
			SelectorI si = (SelectorI) stj;
			SelectorI si2 = (SelectorI) stj2;

			return (100*(si2.getFormated() - si.getFormated())/si2.getFormated());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/api/processador")
	public Integer buscaProcessador(@RequestParam(value="hostName", required = false) String host) {


		try {
			SnmpToJava stj = new SnmpToString(NewChannel.snmpGet(SessionFactory.getInstance(), host, Oid.CPU_IDLE));
			SelectorS si = (SelectorS) stj;
			String s = si.getFormated();
			Integer.parseInt(s.substring(1));
			return 100-Integer.parseInt(s.substring(1));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/api/disco")
	public List<Disco> buscaDisco(@RequestParam(value="hostName", required = false) String host) {
		/* Busca informações de armazenamento no servidor SNMP e retorna um objeto json para o script js
		 * * 
		 * */
		try {
			// Envia uma solicitação ao servidor SNMP e atribui o retorno a uma classe capaz de interpretá-lo
			SnmpToJavaTable stj = new SnmpToJavaTable(NewChannel.snmpTable(SessionFactory.getInstance(), host, Oid.HR_STORAGE_TABLE));
			/*
			 * */
			return TableInterpreter.clearDisk(stj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@GetMapping("/api/rede")
	public Rede buscaRede(@RequestParam(value="hostName", required = false) String host) {
		/* Busca informações de rede no servidor SNMP e retorna um objeto json para o script js
		 * * 
		 * */
		try {
			// Envia uma solicitação ao servidor SNMP e atribui o retorno a uma classe capaz de interpretá-lo
			SnmpToJava stj = new SnmpToString(NewChannel.snmpGet(SessionFactory.getInstance(), host, Oid.INIFOCTETS));
			SnmpToJava stj2 = new SnmpToString(NewChannel.snmpGet(SessionFactory.getInstance(), host, Oid.IFOUTOCTETS));
			
			/* Aplica um casting aos objetos de retorno do SNMP para utilizar os métodos que os traduzem para o java 
			 * Remove informações inúteis do retorno
			 * */
			SelectorS si = (SelectorS) stj;
			SelectorS si2 = (SelectorS) stj2;
			String s = si.getFormated();
			String s1 = si2.getFormated();
			Integer r = (8*Integer.parseInt(s.substring(1)))/3;
			Integer r1 = (8*Integer.parseInt(s1.substring(1)))/3;
			return new Rede(r, r1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * @GetMapping("/api/status") public String
	 * buscaStatus(@RequestParam(value="hostName", required = false) String host){
	 * 
	 * }
	 */
	
	@GetMapping("/api/status")
	public List<Status> teste() {
		try {
			
			SnmpToJava stj = new LldpToString(NewChannel.getLldp(SessionFactory.getInstance()));
			LldpSelector ls = (LldpSelector) stj;
			SnmpToJava stj2 = new SnmpToList(NewChannel.snmpWalk(SessionFactory.getInstance(), ls.getFormated(), Oid.LLDP));
			HostSelector hs = (HostSelector) stj2;
			List<Lldp> lldp = hs.getFormated();
			lldp.add(ls.getFormated());
			SnmpToJava stj3;
			List<Status> listStatus = new ArrayList<Status>();
			
			for(Lldp l : lldp) {
				Status status = new Status();
				stj3 = new SnmpToList(NewChannel.snmpWalk(SessionFactory.getInstance(), l.getHost(), Oid.IFNAME));
				StatusSelector StatS = (StatusSelector) stj3;
				status = StatS.getStatus(status);
				stj3 = new SnmpToList(NewChannel.snmpWalk(SessionFactory.getInstance(), l.getHost(), Oid.IFSTATUS));
				StatS = (StatusSelector) stj3;
				status = StatS.getStatus(status);
				status.setHost(l.getHost());
				listStatus.add(status);
			}
			return listStatus;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}

}
