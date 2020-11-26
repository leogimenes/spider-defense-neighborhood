package spiderdefenseneighborhood.sdnweb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jcraft.jsch.Session;

import spiderdefenseneighborhood.sdnweb.model.Disco;
import spiderdefenseneighborhood.sdnweb.service.NewChannel;
import spiderdefenseneighborhood.sdnweb.service.Oid;
import spiderdefenseneighborhood.sdnweb.service.SessionFactory;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SelectorI;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SelectorS;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SnmpToInteger;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SnmpToJava;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SnmpToJavaTable;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SnmpToString;
import spiderdefenseneighborhood.sdnweb.snmptranslator.TableInterpreter;

@RestController
public class RestControllerAPI {


	@GetMapping("/api/memoria")
	public Integer buscaMemoria(@RequestParam(value="hostName", required = false) String host) {

		Session session = SessionFactory.CreateSession();
		try {
			SnmpToJava stj = new SnmpToInteger(NewChannel.snmpGet(session, "localhost", Oid.MEMORIA_LIVRE));
			SnmpToJava stj2 = new SnmpToInteger(NewChannel.snmpGet(session, "localhost", Oid.MEMORIA_TOTAL));
			SelectorI si = (SelectorI) stj;
			SelectorI si2 = (SelectorI) stj2;
			session.disconnect();

			return (100*(si2.getFormated() - si.getFormated())/si2.getFormated());

		} catch (Exception e) {
			e.printStackTrace();
		}
		session.disconnect();
		return null;
	}

	@GetMapping("/api/processador")
	public Integer buscaProcessador() {
		
		Session session = SessionFactory.CreateSession();
		
		try {
			SnmpToJava stj = new SnmpToString(NewChannel.snmpGet(session, "localhost", Oid.CPU_IDLE));
			SelectorS si = (SelectorS) stj;
			session.disconnect();
			String s = si.getFormated();
			Integer.parseInt(s.substring(1));
			return 100-Integer.parseInt(s.substring(1));

		} catch (Exception e) {
			e.printStackTrace();
		}
		session.disconnect();
		return null;
	}

	@GetMapping("/api/disco")
	public List<Disco> buscaDisco() {
		Session session = SessionFactory.CreateSession();
		try {
			SnmpToJavaTable stj = new SnmpToJavaTable(NewChannel.snmpTable(session, "localhost", Oid.HR_STORAGE_TABLE));
			session.disconnect();

			return TableInterpreter.clearDisk(stj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		session.disconnect();
		return null;
	}
	
	
	@GetMapping("/api/rede")
	public Integer buscaRede() {
		
		Session session = SessionFactory.CreateSession();
		
		try {
			SnmpToJava stj = new SnmpToString(NewChannel.snmpGet(session, "localhost", Oid.BITS_DOWNLOAD));
			SelectorS si = (SelectorS) stj;
			session.disconnect();
			String s = si.getFormated();
			return (8*Integer.parseInt(s.substring(1)))/3;

		} catch (Exception e) {
			e.printStackTrace();
		}
		session.disconnect();
		return null;
	}
	
	@GetMapping("/api/status")
	public String buscaStatus(){
		
		
		
		
		return "offline";
	}
}
