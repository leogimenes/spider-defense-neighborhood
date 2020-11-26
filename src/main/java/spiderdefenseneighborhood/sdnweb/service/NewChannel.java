package spiderdefenseneighborhood.sdnweb.service;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

public class NewChannel {
	private static String Interpreter;	

	private static String getInterpreter() {
		return Interpreter;
	}

	private static void setInterpreter(String interpreter) {
		Interpreter = interpreter;
	}

	public static String snmpGet(String hostname, String oid) throws Exception {
		String command= "snmpget -v2c -Ov -c public " + hostname + " " + oid;

		Session session = SessionFactory.CreateSession();

		Channel channel=session.openChannel("exec");
		((ChannelExec)channel).setCommand(command);

		channel.setInputStream(null);

		((ChannelExec)channel).setErrStream(System.err);

		InputStream in=channel.getInputStream();

		channel.connect();

		byte[] tmp=new byte[1024];
		while(true){

			while(in.available()>0){
				int i=in.read(tmp, 0, 1024);
				NewChannel.setInterpreter(new String(tmp, 0, i));
				if(i<0)break;
			}
			if(channel.isClosed()){
				if(in.available()>0) continue; 
				break;
			}
			try{Thread.sleep(1000);}
			catch(Exception ee){}
		}
		channel.disconnect();
		session.disconnect();
		return NewChannel.getInterpreter();
	}

	public static String snmpGet(Session session, String hostname, String oid) throws Exception {
		String command= "snmpget -v2c -Ov -c public " + hostname + " " + oid;

		Channel channel=session.openChannel("exec");
		((ChannelExec)channel).setCommand(command);

		channel.setInputStream(null);

		((ChannelExec)channel).setErrStream(System.err);

		InputStream in=channel.getInputStream();

		channel.connect();

		byte[] tmp=new byte[1024];
		while(true){

			while(in.available()>0){
				int i=in.read(tmp, 0, 1024);
				NewChannel.setInterpreter(new String(tmp, 0, i));
				if(i<0)break;
			}
			if(channel.isClosed()){
				if(in.available()>0) continue; 
				break;
			}
			try{Thread.sleep(1000);}
			catch(Exception ee){}
		}
		channel.disconnect();
		return NewChannel.getInterpreter();
	}

	public static String snmpTable(Session session, String hostname, String oid) throws Exception {


		String command= "snmptable -v2c -CH -Cf , -c public " + hostname + " " + oid;

		Channel channel=session.openChannel("exec");
		((ChannelExec)channel).setCommand(command);

		channel.setInputStream(null);

		((ChannelExec)channel).setErrStream(System.err);

		InputStream in=channel.getInputStream();

		channel.connect();

		byte[] tmp=new byte[1024];
		while(true){

			while(in.available()>0){
				int i=in.read(tmp, 0, 1024);
				NewChannel.setInterpreter(new String(tmp, 0, i));
				if(i<0)break;
			}
			if(channel.isClosed()){
				if(in.available()>0) continue; 
				break;
			}
			try{Thread.sleep(1000);}
			catch(Exception ee){}
		}
		channel.disconnect();
		return NewChannel.getInterpreter();
	}

}
