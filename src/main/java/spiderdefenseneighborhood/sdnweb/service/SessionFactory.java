package spiderdefenseneighborhood.sdnweb.service;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

public class SessionFactory {
	@SuppressWarnings("unused")
	private static SessionFactory instance;
	private static Session session;
	
	private SessionFactory() {
		try{
			JSch jsch=new JSch();  

			String host=null;
			host="cumulus@192.168.0.150"; 
			String user=host.substring(0, host.indexOf('@'));
			host=host.substring(host.indexOf('@')+1);

			session=jsch.getSession(user, host, 22);

			UserInfo ui=new MyUserInfo();
			session.setUserInfo(ui);
			session.connect();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static Session getInstance() {
		if (session == null) {
			instance = new SessionFactory();
		}
		return session;
	}
	
}
