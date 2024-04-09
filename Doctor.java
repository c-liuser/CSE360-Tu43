

import java.util.*;

class Doctor{
	String userName;
	String password;
	ArrayList<String> msgsSent;
	ArrayList<String> msgsReceived;
	
	public Doctor(String userNames, String passwords) {
		userName = userNames;
		password = passwords;
	}
	
	public String getUser() {return userName;}
	public String getPass() {return password;}
	public void sendMsg(String msg, Patient to) {
		msgsSent.add(msg);
	}
	public ArrayList<String> getMsgs() {
		return msgsReceived;
	}
	
};
