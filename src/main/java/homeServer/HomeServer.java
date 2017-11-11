package homeServer;

import builder.ConfigManagerBuilder;
import builder.ConnectionManagerBuilder;
import builder.DatabaseManagerBuilder;
import builder.DeviceManagerBuilder;
import builder.SystemComponent;
import homeServer.deviceManager.DeviceManager;
import test.*;

public class HomeServer {
	private DatabaseManager databaseManager = (DatabaseManager) new DatabaseManagerBuilder().createInstance()
														.setDBUserName("User10")
														.setDBPassword("ASFW$WAFasf45")
														.setDBIP("192.168.1.1").build();
	private ConfigManager configManager = (ConfigManager) new ConfigManagerBuilder().setConfigFileName("interceptorConfig.xml").build();
	private DeviceManager deviceManager = (DeviceManager) new DeviceManagerBuilder().createInstance().setDatabaseManager(databaseManager).build();
	private ConnectionManager connectionManager = (ConnectionManager) new ConnectionManagerBuilder().createInstance().build();
	private AbstractLogger logger = (new LoggerFactory()).getSystemInfoLogger();

	private Initaliser initaliser;
	
	public HomeServer(String configFileName){
		initalise(configFileName);
	}
	
	private void initalise(String configFileName) {
		this.initaliser = new Initaliser(logger, configFileName, databaseManager, 
				configManager, deviceManager, connectionManager);
		logger =  initaliser.getLogger();
		logger.logMessage(1, "System initalised Sucuesfully");
		logger.logMessage(2, "Error No More Program");
	}
	
	public static void main(String[] args) {
		HomeServer homeServer =  new HomeServer(args[0]);
		Test.test();
	}
}
  