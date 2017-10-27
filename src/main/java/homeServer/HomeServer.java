package homeServer;

public class HomeServer {
	private Initaliser initaliser;
	private DatabaseManager databaseManager = new DatabaseManager();
	private ConfigManager configManager = new ConfigManager();
	private DeviceManager deviceManager = new DeviceManager();
	private ConnectionManager connectionManager = new ConnectionManager();
	
	public HomeServer(String configFileName){
		initalise(configFileName);
	}
	
	private void initalise(String configFileName) {
		this.initaliser = new Initaliser(configFileName, databaseManager, configManager, deviceManager, connectionManager);
	}
	
	public static void main(String[] args) {
		HomeServer homeServer =  new HomeServer(args[0]);
		
	}
}
  