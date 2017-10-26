package homeServer;

public class DatabaseManager {
	private String databaseUserName = "";
	private String databasePassword = "";
	private String databaseIP = "";
	
	public DatabaseManager() {
		
	}		

	protected void setConfigDetails(ConfigManager configManager) {
		setDatabaseUserName(configManager.getDatabaseUserName());
		setDatabasePassword(configManager.getDatabasePassword());
		setDatabaseIP(configManager.getDatabaseIP());
	}

	public void setDatabaseIP(String datbaseIP) {
		this.databaseIP = datbaseIP;                    
	}                               
                                    
	public void setDatabasePassword(String datbasePassword) {
		this.databasePassword = datbasePassword;                     
	}                               
                                    
	public void setDatabaseUserName(String datbaseUserName) {
		this.databaseUserName = datbaseUserName;
	}

}
