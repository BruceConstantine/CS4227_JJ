package homeServer;

public class Initaliser {
	private AbstractLogger logger;
	private DatabaseManager databaseManager;
	private ConfigManager configManager;
	private DeviceManager deviceManager;
	private ConnectionManager connectionManager;
	
	Initaliser(AbstractLogger logger, String configFileName, DatabaseManager databaseManager, 
			ConfigManager configManager, DeviceManager deviceManager, 
			ConnectionManager connectionManager){	
		logger.logMessage(1, "[Notice] Initalising");
		setLogger(logger);
		setConfigManager(configManager);
		loadConfigFile(configFileName);
		setDatabaseManager(databaseManager);
		initaliseDatabaseManager();
		initaliseLogger();
		setDeviceManager(deviceManager);
		initalisedeviceManager();
		setConnectionManager(connectionManager);
		initaliseConnectionManager();
		
	}

	public Initaliser() {
		
	}
	
	private void setLogger(AbstractLogger abstractLogger) {
		this.logger = abstractLogger;
	}
	
	private void loadConfigFile(String configFileName) {
		configManager.setConfigFileName(configFileName);
		logger.logMessage(1, "[Notice] Config File Loaded");
	}

	private void initaliseDatabaseManager() {
		databaseManager.setConfigDetails(configManager);
		logger.logMessage(1, "[Notice] Database Manager Initalised");
	}
	
	private void initaliseLogger() {
		LoggerFactory loggerFactory= new LoggerFactory();
		setLogger(loggerFactory.initaliseLoggerChain(databaseManager));
		logger.logMessage(1, "[Notice] Logger Initalised - Database Manager Loaded");
	}
	
	private void initaliseConnectionManager() {
		connectionManager = new ConnectionManager(databaseManager);
		connectionManager.initalise();
	}
	
	private void initalisedeviceManager() {
		deviceManager.initalise();
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
