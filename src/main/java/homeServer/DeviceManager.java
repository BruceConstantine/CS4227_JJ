package homeServer;

public class DeviceManager {
	
	private DatabaseManager databaseManager;
	
	public DeviceManager() {
		this.databaseManager = databaseManager;
	}
	
	public void initalise() {
		loadDeviceCongigFromDB();
	}	
	
	public void loadDeviceCongigFromDB() {
		// loads the configuration information for the device manager from the data base
		
	}
	
	public void setDatabaseManager(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

}
