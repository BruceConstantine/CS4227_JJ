package homeServer;

public class Initaliser {
	private DatabaseManager databaseManager;
	private ConfigManager configManager;
	private DeviceManager deviceManager;
	private ConnectionManager connectionManager;
	
	Initaliser(String configFileName, DatabaseManager databaseManager, ConfigManager configManager, DeviceManager deviceManager, ConnectionManager connectionManager){		
		setConfigManager(configManager);
		loadConfigFile(configFileName);
		setDatabaseManager(databaseManager);
		initaliseDatabaseManager();
		setDeviceManager(deviceManager);
		initalisedeviceManager();
		setConnectionManager(connectionManager);
		initaliseConnectionManager();
	}

	public Initaliser() {
		
	}

	private void loadConfigFile(String configFileName) {
		configManager.setConfigFileName(configFileName);
	}

	private void initaliseDatabaseManager() {
		databaseManager.setConfigDetails(configManager);		
	}
	
	private void initaliseConnectionManager() {
		connectionManager = new ConnectionManager(databaseManager);
		connectionManager.initalise();
	}
	
	private void initalisedeviceManager() {
		deviceManager.initalise(databaseManager);
	}
	
	private void setConfigManager(ConfigManager configManager) {
		this.configManager = configManager;
	}
	
	private void setDatabaseManager(DatabaseManager databaseManager) {
		this.databaseManager =databaseManager;
	}
	
	private void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	private void setDeviceManager(DeviceManager deviceManager) {
		this.deviceManager = deviceManager;
	}
	
}
