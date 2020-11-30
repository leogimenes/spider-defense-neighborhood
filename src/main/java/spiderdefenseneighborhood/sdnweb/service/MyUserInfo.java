package spiderdefenseneighborhood.sdnweb.service;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

public class MyUserInfo implements UserInfo, UIKeyboardInteractive{
	public String getPassword(){ return passwd; }
	public boolean promptYesNo(String str){
		int foo = 0;
		return foo==0;
	}

	String passwd = "dn14q8m6";
	JTextField passwordField=(JTextField)new JPasswordField(20);

	public String getPassphrase(){ return null; }

	public boolean promptPassphrase(String message){ return true; }

	public boolean promptPassword(String message){    	
		return true;
	}
	public void showMessage(String message){
		JOptionPane.showMessageDialog(null, message);
	}


	@Override
	public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt,
			boolean[] echo) {
		return null;
	}

}