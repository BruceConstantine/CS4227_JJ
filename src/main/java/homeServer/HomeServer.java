package homeServer;

public class HomeServer {
	private Initaliser initaliser;
	private DatabaseManager databaseManager = new DatabaseManager();
	private ConfigManager configManager = new ConfigManager();
	private DeviceManager deviceManager = new DeviceManager();
	private ConnectionManager connectionManager = new ConnectionManager();
	private AbstractLogger logger = (new LoggerFactory()).getSystemInfoLogger();
	
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
	}
}
  