package homeServer;

public class Initaliser {
	private DatabaseManager databaseManager;
	private ConfigManager configManager;
	private DeviceManager deviceManager;
	private ConnectionManager connectionManager;
	
	Initaliser(String configFileName, DatabaseManager databaseManager, ConfigManager configManager, DeviceManager deviceManager, ConnectionManager connectionManager){		
		loadConfigFile(configFileName);
		this.databaseManager = databaseManager;
		initaliseDatabaseManager();
		this.deviceManager = deviceManager;
		initalisedeviceManager();
		this.connectionManager = connectionManager;
		initaliseConnectionManager();
	}
	
	private void loadConfigFile(String configFileName) {
		setConfigManager(new ConfigManager(configFileName));
	}

	private void initaliseDatabaseManager() {
		databaseManager = new DatabaseManager(configManager);		
	}
	
	private void initaliseConnectionManager() {
		connectionManager = new ConnectionManager(databaseManager);
		connectionManager.initalise();
	}
	
	private void initalisedeviceManager() {
		deviceManager = new DeviceManager(databaseManager);
		deviceManager.initalise();
	}
	
	private void setConfigManager(ConfigManager configManager) {
		this.configManager = configManager;
	}

//	public StringBuilder getSummary() {
//		StringBuilder initalisationSummary = new StringBuilder();
//		initalisationSummary.append();
//		initalisationSummary.append();
//		initalisationSummary.append();
//		initalisationSummary.append();
//		return initalisationSummary;
//	}
	
}
