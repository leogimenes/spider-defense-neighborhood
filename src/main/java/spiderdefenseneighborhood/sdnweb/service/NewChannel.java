package spiderdefenseneighborhood.sdnweb.service;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

import spiderdefenseneighborhood.sdnweb.model.Lldp;

public class NewChannel {
	private static String Interpreter;	

	private static String getInterpreter() {
		return Interpreter;
	}

	private static void setInterpreter(String interpreter) {
		Interpreter = interpreter;
	}
	
	public static String getLldp(Session session) throws Exception {
		
		String command= "sudo lldpcli show neighbors summary | grep -e SysName -e Interface";
		
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

	public static String snmpGet(Session session, String host, String oid) throws Exception {
		String command= "snmpget -v2c -Ov -c public " + host + " " + oid;

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
	
	public static String snmpWalk(Session session, String host, String oid) throws Exception {

		String command= "snmpwalk -v2c -Oqv -c public " + host + " " + oid;

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
	
	public static String snmpWalk(Session session, Lldp host, String oid) throws Exception {

		String command= "snmpwalk -v2c -Oqv -c public " + host.getHost() + " " + oid +  " | grep -v -e swp -e eth ";

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
