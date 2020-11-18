package spiderdefenseneighborhood.sdnweb.model;

import javax.swing.JOptionPane;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

public class Shell{
	public static void main(String[] arg){

		try{
			JSch jsch=new JSch();


			String host=null;
			if(arg.length>0){
				host=arg[0];
			}
			else{
				host="cumulus@192.168.0.150";  
			}
			String user=host.substring(0, host.indexOf('@'));
			host=host.substring(host.indexOf('@')+1);

			Session session=jsch.getSession(user, host, 22);

			String passwd = "dn14q8m6";
			session.setPassword(passwd);

			UserInfo ui = new MyUserInfo(){
				public void showMessage(String message){
					JOptionPane.showMessageDialog(null, message);
				}
				public boolean promptYesNo(String str){
					int foo = 0;
					return foo==0;
				}
			};

			session.setUserInfo(ui);

			session.connect(30000);   // making a connection with timeout.

			Channel channel=session.openChannel("shell");

			channel.setInputStream(System.in);

			channel.setOutputStream(System.out);
			channel.connect(3*1000);
			while(channel.isConnected()) {
				Thread.sleep(1000);
			}
			System.exit(0);
		
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public static abstract class MyUserInfo
	implements UserInfo, UIKeyboardInteractive{
		public String getPassword(){ return null; }
		public boolean promptYesNo(String str){ return false; }
		public String getPassphrase(){ return null; }
		public boolean promptPassphrase(String message){ return false; }
		public boolean promptPassword(String message){ return false; }
		public void showMessage(String message){ }
		public String[] promptKeyboardInteractive(String destination,
				String name,
				String instruction,
				String[] prompt,
				boolean[] echo){
			return null;
		}
	}
}