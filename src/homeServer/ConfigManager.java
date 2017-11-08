package homeServer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 
 * Patrick
 * 
 * @DSC
 * Loads interceptor.config details from the interceptor.config file. 
 * Stores Config details as a map of key value pairs
 * Details used by database to load from DB
 * Supports writing details to file
 */
public class ConfigManager {
	private Map<String,String> configValues;
	private String configFileName;

	
	public void setConfigFileName(String configFileName) {
		this.configFileName = configFileName;
		loadConfigDetails();
	}
	
	private void loadConfigDetails() {
		// Reads details from interceptor.config file into the interceptor.config object properties.
		// Below values are hard coded for brevity
		configValues = new HashMap<String, String>();
		configValues.put("DATABASE_USER_NAME", "aUser");
		configValues.put("DATABASE_IP", "192.168.1.1");
		configValues.put("DATABASE_PASSWORD", "asdf123");
		configValues.put("WEB_SERVER_IP", "223.552.33.423");
		configValues.put("HOME_SERVER_ROTATING_ID", "rf34fw4f5y4");
	}
	
	public void writeConfigDetailsToFile() {
		// Write Config details to file.
	}
	
	public String getDatabaseUserName() {
		return configValues.get("DATABASE_USER_NAME");
	}
	
	public String getDatabasePassword() {
		return configValues.get("DATABASE_PASSWORD");
	}
	
	public String getDatabaseIP() {
		return configValues.get("DATABASE_IP");
	}

}
