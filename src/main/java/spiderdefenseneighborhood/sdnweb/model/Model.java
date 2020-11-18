package spiderdefenseneighborhood.sdnweb.model;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.InputStream;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

public class Model{
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
      
      // username and password will be given via UserInfo interface.
      UserInfo ui=new MyUserInfo();
      session.setUserInfo(ui);
      session.connect();

      String command= "sudo tail -f /var/log/syslog";

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
          System.out.print(new String(tmp, 0, i));
//          if(log.equals("exit"))
          if(i<0)break;
        }
        if(channel.isClosed()){
          if(in.available()>0) continue; 
          System.out.println("exit-status: "+channel.getExitStatus());
          break;
        }
        try{Thread.sleep(1000);}
        catch(Exception ee){}
      }
      channel.disconnect();
      session.disconnect();
    }
    catch(Exception e){
      System.out.println(e);
    }
  }

  public static class MyUserInfo implements UserInfo, UIKeyboardInteractive{
    public String getPassword(){ return passwd; }
    public boolean promptYesNo(String str){
    	int foo = 0;
       return foo==0;
    }
  
    String passwd;
    JTextField passwordField=(JTextField)new JPasswordField(20);

    public String getPassphrase(){ return null; }
    
    public boolean promptPassphrase(String message){ return true; }
    
    public boolean promptPassword(String message){    	
    	passwd = "dn14q8m6";
    	return true;
    }
    public void showMessage(String message){
      JOptionPane.showMessageDialog(null, message);
    }
    final GridBagConstraints gbc = 
      new GridBagConstraints(0,0,1,1,1,1,
                             GridBagConstraints.NORTHWEST,
                             GridBagConstraints.NONE,
                             new Insets(0,0,0,0),0,0);

	@Override
	public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt,
			boolean[] echo) {
		return null;
	}
    
  }
}