package homeServer;

public class DatabaseManager {
	private String databaseUserName = "User10";
	private String databasePassword = "ASFW$WAFasf45";
	private String databaseIP = "192.168.1.1";
	
	public DatabaseManager() {
		
	}		

	public DatabaseManager(ConfigManager configManager) {
		updateConfigDetails(configManager);
	}

	protected void updateConfigDetails(ConfigManager configManager) {
		//update the database IP and credentials using the config manager.
	}

}
