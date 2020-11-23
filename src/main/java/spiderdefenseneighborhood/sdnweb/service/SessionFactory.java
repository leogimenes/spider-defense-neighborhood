package spiderdefenseneighborhood.sdnweb.service;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

public class SessionFactory {
	
	public static Session CreateSession() {
		try{
			JSch jsch=new JSch();  

			String host=null;
			host="cumulus@192.168.0.150"; 
			String user=host.substring(0, host.indexOf('@'));
			host=host.substring(host.indexOf('@')+1);

			Session session=jsch.getSession(user, host, 22);

			UserInfo ui=new MyUserInfo();
			session.setUserInfo(ui);
			session.connect();
			return session;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
}
