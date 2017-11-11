package homeServer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

import org.apache.tomcat.jni.File;

import builder.SystemComponent;

public class DatabaseManager implements SystemComponent{
	private String databaseUserName = "User10";
	private String databasePassword = "ASFW$WAFasf45";
	private String databaseIP = "192.168.1.1";
	
	public DatabaseManager() {
		
	}		

	protected void setConfigDetails(ConfigManager configManager) {
		setDatabaseUserName(configManager.getDatabaseUserName());
		setDatabasePassword(configManager.getDatabasePassword());
		setDatabaseIP(configManager.getDatabaseIP());
	}

	public void setDatabaseIP(String datbaseIP) {
		this.databaseIP = datbaseIP;                    
	}                               
                                    
	public void setDatabasePassword(String datbasePassword) {
		this.databasePassword = datbasePassword;                     
	}                               
                                    
	public void setDatabaseUserName(String datbaseUserName) {
		this.databaseUserName = datbaseUserName;
	}

	public void writeSystemError(String message) {
		//Execute the code for writing to database 
		System.out.println("[FOR TESTING::WRITING ERROR TO DATABASE]" + message);
	}
	public boolean validateUserCredentials(String userName, String userPassword) {
		// Check user credentials against the users in the database. 
		if(userName.equals("Martin") && userPassword.equals("userPW"))
			return true;
		if(userName.equals("Murphy") && userPassword.equals("userPW"))
			return true;
		return false;
	}

	public boolean validateHomeServerCredentials(String homeServerID, String homeServerPassword) {
		// Check home server credentials against the users in the database. 
		if(homeServerID.equals("MurphysServer") && homeServerPassword.equals("serverPW"))
			return true;
		if(homeServerID.equals("MartinsServer") && homeServerPassword.equals("serverPW"))
			return true;	
		return false;
	}
/////////////////    read info of device  from database   //////////////////////

	public Scanner getPrecedureStoreReader() {
		Scanner in = null;
		in = new Scanner("homeServer/schedular/dbReader/procedureStore.txt");
		return  in;
	}
	
	public String getPrecedureStoreContent() {
		String result = "";
		String filename = "src\\main\\java\\homeServer\\schedular\\dbReader\\procedureStore.txt";
		Scanner in = null;
		try {
			in = new Scanner(new java.io.File(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(in.hasNext()){
			result+=in.nextLine()+";";
		}
		return result;
	}
	
	public String getDevicesInfoFromDB(){
		//
		String dInfo = "type,name,classId";
		return dInfo;
	}
	
}
