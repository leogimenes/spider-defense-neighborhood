package spiderdefenseneighborhood.sdnweb.service;

import java.awt.GridBagConstraints;
import java.awt.Insets;

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