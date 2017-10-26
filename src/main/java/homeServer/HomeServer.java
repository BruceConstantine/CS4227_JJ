package homeServer;

public class HomeServer {
	private Initaliser initaliser;
	private DatabaseManager databaseManager;
	private ConfigManager configManager;
	private DeviceManager deviceManager;
	private ConnectionManager connectionManager;
	
	public HomeServer(String configFileName){
		initalise(configFileName);
		
		initaliser.test();
	}
	
	private void initalise(String configFileName) {
		this.initaliser = new Initaliser(configFileName, databaseManager, configManager, deviceManager, connectionManager);
//		System.out.println(initaliser.getSummary());
	}

}
  