package homeServer;

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

}
