package builder;

import homeServer.DatabaseManager;
import homeServer.deviceManager.DeviceManager;

public class DeviceManagerBuilder implements AbsBuilder {

	private DeviceManager deManager;
	
	@Override
	public SystemComponent build() { 
		return deManager;
	}
	
	@Override
	public DeviceManagerBuilder createInstance() { 
		deManager = new DeviceManager();
		return this;
	}

	public DeviceManagerBuilder setDatabaseManager(DatabaseManager dbManager) {
		deManager.setDatabaseManager(dbManager);
		return this;
	}
}
