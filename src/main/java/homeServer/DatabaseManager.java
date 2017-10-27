package homeServer;

import java.util.ArrayList;
import java.util.List;

import DevicesPackage.Devices;

public class DatabaseManager {
	private String databaseUserName = "User10";
	private String databasePassword = "ASFW$WAFasf45";
	private String databaseIP = "192.168.1.1";
	
	public List<Devices> devices = new ArrayList<Devices>();
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
	
	public void registerDevices(Devices d){
		devices.add(d);

	}

}
