package homeServer;

import java.util.List;

import DevicesPackage.Devices;
import Factory.DevicesFactory;

public class DeviceManager {
	
	private DatabaseManager databaseManager;
	
	public DeviceManager(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}
	
	public void initalise() {
		loadDeviceCongigFromDB();
	}	
	
	public void loadDeviceCongigFromDB() {
		//loads the config for the devices from the data base
		
	}
	
	public void setDatabaseManager(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}
	
	//create devices--meiyu
	public void createDevices(String type, String name){
		DevicesFactory df = new DevicesFactory();
		Devices d = df.createDevices(type, name);
		
		databaseManager.registerDevices(d);
	}

}
