package spiderdefenseneighborhood.sdnweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spiderdefenseneighborhood.sdnweb.model.Lldp;
import spiderdefenseneighborhood.sdnweb.service.NewChannel;
import spiderdefenseneighborhood.sdnweb.service.Oid;
import spiderdefenseneighborhood.sdnweb.service.SessionFactory;
import spiderdefenseneighborhood.sdnweb.snmptranslator.HostSelector;
import spiderdefenseneighborhood.sdnweb.snmptranslator.LldpSelector;
import spiderdefenseneighborhood.sdnweb.snmptranslator.LldpToString;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SnmpToJava;
import spiderdefenseneighborhood.sdnweb.snmptranslator.SnmpToList;

@Controller
public class WebController {
	
	@GetMapping(value = {"/", "/dashboard"})
	public ModelAndView index(@RequestParam(value="hostName",defaultValue = "oobmgmtserver") String host,ModelAndView map) {
		map = new ModelAndView("dashboard");
		map.addObject("hostName", host);
		
		return map;
	}
	
	@GetMapping(value = {"/dispositivos"})
	public ModelAndView dispositivos (ModelAndView map) {
		map = new ModelAndView("dispositivos");
		try {
			SnmpToJava stj = new LldpToString(NewChannel.getLldp(SessionFactory.getInstance()));
			LldpSelector ls = (LldpSelector) stj;
			SnmpToJava stj2 = new SnmpToList(NewChannel.snmpWalk(SessionFactory.getInstance(), ls.getFormated(), Oid.LLDP));
			HostSelector hs = (HostSelector) stj2;
			
			List<Lldp> lldp = hs.getFormated();
			lldp.add(ls.getFormated());
			map.addObject("hosts", lldp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
