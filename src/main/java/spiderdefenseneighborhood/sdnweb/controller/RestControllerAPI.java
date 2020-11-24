package spiderdefenseneighborhood.sdnweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcraft.jsch.Session;

import spiderdefenseneighborhood.sdnweb.service.NewChannel;
import spiderdefenseneighborhood.sdnweb.service.Oid;
import spiderdefenseneighborhood.sdnweb.service.SessionFactory;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SelectorI;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SnmpToInteger;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SnmpToJava;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SnmpToJavaTable;
import spiderdefenseneighborhood.sdnweb.snmptranslator.TableInterpreter;
import spiderdefenseneighborhood.sdnweb.snmptranslator.TableSelector;

@RestController
public class RestControllerAPI {

//
//	@GetMapping("/api/memoria")
//	public Integer buscaMemoria() {
//
//		Session session = SessionFactory.CreateSession();
//		try {
//			SnmpToJava stj = new SnmpToInteger(NewChannel.snmpGet(session, "localhost", Oid.MEMORIA_LIVRE));
//			SnmpToJava stj2 = new SnmpToInteger(NewChannel.snmpGet(session, "localhost", Oid.MEMORIA_TOTAL));
//			SelectorI si = (SelectorI) stj;
//			SelectorI si2 = (SelectorI) stj2;
//			session.disconnect();
//
//			return (100*(si2.getFormated() - si.getFormated())/si2.getFormated());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		session.disconnect();
//		return null;
//	}
//
//	@GetMapping("/api/processador")
//	public Integer buscaProcessador() {
//		Session session = SessionFactory.CreateSession();
//		try {
//			SnmpToJava stj = new SnmpToInteger(NewChannel.snmpGet(session, "localhost", Oid.CPU_IDLE));
//			SelectorI si = (SelectorI) stj;
//			session.disconnect();
//
//			return 100-si.getFormated();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		session.disconnect();
//		return null;
//	}
//
//	@GetMapping("/api/disco")
//	public List<List<String>> buscaDisco() {
//		Session session = SessionFactory.CreateSession();
//		try {
//			SnmpToJavaTable stj = new SnmpToJavaTable(NewChannel.snmpTable(session, "localhost", Oid.HR_STORAGE_TABLE));
//			TableSelector ts = (TableSelector) stj;
//			TableInterpreter.clearDisk(stj);
//			session.disconnect();
//
//			return ts.getFormated();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		session.disconnect();
//		return null;
//	}

	
	@GetMapping("/api/status")
	public String buscaStatus(){
		
		
		
		
		return "offline";
	}
}
