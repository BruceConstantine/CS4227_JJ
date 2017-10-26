package homeServer;

import java.util.ArrayList;
import java.util.List;

import DevicesPackage.Devices;

public class DatabaseManager {
	private String databaseUserName = "";
	private String databasePassword = "";
	private String databaseIP = "";
	
	//to store registered devices--meiyu
	public List<Devices> devices = new ArrayList<Devices>();
	
	public DatabaseManager() {
		
	}		

	protected void updateConfigDetails(ConfigManager configManager) {
		//update the database IP and credentials using the config manager.
	}
	
	//to register devices which already created by device manager--meiyu 
	public void registerDevices(Devices d){
		devices.add(d);
		
	}
	

}
