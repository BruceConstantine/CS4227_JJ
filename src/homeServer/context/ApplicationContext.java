package homeServer.context;

import homeServer.*;
import homeServer.core.dispatcher.Dispatcher;
import homeSever.core.MSGManager;

public class ApplicationContext {
	 
	private static AbstractLogger logger;
	private static DatabaseManager databaseManager;
	private static ConfigManager configManager;
	private static DeviceManager deviceManager;
	private static ConnectionManager connectionManager;
	private static MSGManager msgManager;

	public static void initAppContext(AbstractLogger logger, DatabaseManager databaseManager, 
								ConfigManager configManager, 
								DeviceManager deviceManager, 
								ConnectionManager connectionManager ) { 
		ApplicationContext.configManager = configManager;
		ApplicationContext.logger = logger;
		ApplicationContext.databaseManager = databaseManager;
		ApplicationContext.connectionManager = connectionManager;
		ApplicationContext.deviceManager = deviceManager;
	}
  
	public static AbstractLogger getLogger() {
		return logger;
	}

	public static void setLogger(AbstractLogger logger) {
		ApplicationContext.logger = logger;
	}

	public static DatabaseManager getDatabaseManager() {
		return databaseManager;
	}

	public static void setDatabaseManager(DatabaseManager databaseManager) {
		ApplicationContext.databaseManager = databaseManager;
	}

	public static ConfigManager getConfigManager() {
		return configManager;
	}

	public static void setConfigManager(ConfigManager configManager) {
		ApplicationContext.configManager = configManager;
	}

	public static DeviceManager getDeviceManager() {
		return deviceManager;
	}

	public static void setDeviceManager(DeviceManager deviceManager) {
		ApplicationContext.deviceManager = deviceManager;
	}

	public static ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	public static void setConnectionManager(ConnectionManager connectionManager) {
		ApplicationContext.connectionManager = connectionManager;
	}

	public static MSGManager getMsgManager() {
		return msgManager;
	}

	public static void setMsgManager(MSGManager msgManager) {
		ApplicationContext.msgManager = msgManager;
	}
	 
}
